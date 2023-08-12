import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        //Gui отвечает за графическую соствляющую
        Gui guiobject = new Gui();
        guiobject.setup();
        //Таймер осуществляет цикл
        TimerListener taimer = new TimerListener();
        Timer timer = new Timer(100, taimer);
        timer.start();
    }
}

    //Класс обработчика событий для таймера
    class TimerListener implements ActionListener
    {
        //Метод считает количество муравьёв

        public void actionPerformed(ActionEvent evt)
        {
            //Указатель для доступа к полю, ПОЛЕ это SINGLETON
            Pole mypole = Pole.getInstance();
            //Указатель на насекомых которые расположены в поле
            Nasekomoe myNas;
            int novkoordinata;

            //Проверяем установлен ли флажок начать бесконечный цикл
            if(Example.flashok == true) {
                //Проверяем не достигли ли максимального количества муравьёв
                if (Example.KolMuraviev() <= ((Example.N * Example.N) / 2)) {
                    for (int i = 0; i < Example.N; i++) {
                        for (int j = 0; j < Example.N; j++) {
                            if (mypole.pol[i][j].nas != null) {
                                myNas = mypole.pol[i][j].getNasekomoe();
                                novkoordinata = myNas.smenasostoania();
                                //mypole.pol[i][j].nas = null;
                                mypole.pol[i][j].setNasekomoe(null);
                                mypole.pol[i][j].flagpererisovki = true;

                                if (novkoordinata == 0) {
                                    //koordinata = kletk.getKoordinataX()+1;
                                    mypole.pol[i + 1][j].setNasekomoe(myNas);
                                    mypole.pol[i + 1][j].flagpererisovki = true;
                                }
                                if (novkoordinata == 1) {
                                    //koordinata = kletk.getKoordinataY()+1;
                                    mypole.pol[i][j + 1].setNasekomoe(myNas);
                                    mypole.pol[i][j + 1].flagpererisovki = true;
                                }
                                if (novkoordinata == 2) {
                                    //koordinata = kletk.getKoordinataX()-1;
                                    mypole.pol[i - 1][j].setNasekomoe(myNas);
                                    mypole.pol[i - 1][j].flagpererisovki = true;
                                }
                                if (novkoordinata == 3) {
                                    //koordinata = kletk.getKoordinataY()-1;
                                    mypole.pol[i][j - 1].setNasekomoe(myNas);
                                    mypole.pol[i][j - 1].flagpererisovki = true;
                                }
                            }
                        }
                    }
                    Example.frame.repaint();
                } else {
                    Example.flashok = false;
                }
            }
        }
    };

     class Gui implements ActionListener{

        JButton buttonPlusEda;
        JButton buttonPlusMuravei;
        JButton buttonNachat;
        JButton buttonStop;


         //СОЗДАЮТСЯ ВИЗУАЛЬНЫЕ КОМПОНЕНТЫ
        public void setup() {
            //Создаём фрейм и панели
            Example.frame = new JFrame();
            MyDrawPanel mypanel = new MyDrawPanel();
            //JPanel panel1 = new JPanel();
            JPanel panel2 = new JPanel();
            JPanel panel3 = new JPanel();
            JPanel panel4 = new JPanel();
            JPanel panel5 = new JPanel();

            //Устанавливаем режим компоновки для второй панели и пятой
            panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
            panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

            //Создаём кнопки
            buttonPlusEda = new JButton("+ ЕДА");
            buttonPlusMuravei = new JButton("+ МУРАВЕЙ");
            buttonNachat = new JButton("СТАРТ");
            buttonStop = new JButton("ПАУЗА");

            //Создаю обработчики событий для кнопок
            buttonPlusEda.addActionListener(this);
            buttonPlusMuravei.addActionListener(this);
            buttonNachat.addActionListener(this);
            buttonStop.addActionListener(this);
            buttonStop.setEnabled(false);



            //Создаём тектовые поля
            JTextField textfield1 = new JTextField(3);
            JTextField textfield2 = new JTextField(3);
            JLabel text1 = new JLabel();
            JLabel text2 = new JLabel();
            textfield1.setText(" 0");
            textfield2.setText(" 0");
            text1.setText("Кол-во еды:");
            text2.setText("Кол-во муравьев:");

            //Добавляем кнопки на вторую панель
            panel2.add(buttonPlusEda);
            panel2.add(buttonPlusMuravei);
            panel2.add(buttonNachat);
            panel2.add(buttonStop);

            //Добавляем тектовые поля на 3 и 4 панель
            panel3.add(text1);
            panel3.add(textfield1);
            panel4.add(text2);
            panel4.add(textfield2);
            panel5.add(panel3);
            panel5.add(panel4);

            //Добавляем панели на фрейм
            Example.frame.getContentPane().add(BorderLayout.WEST, panel2);
            Example.frame.getContentPane().add(BorderLayout.EAST, panel5);
            Example.frame.getContentPane().add(BorderLayout.CENTER, mypanel);



            //Устанавливаем размер фрейма делаем его видимым и завершаем работу программы при закрытии окна
            Example.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Example.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Example.frame.setVisible(true);


        //СОЗДАЮТСЯ ОБЪЕКТЫ ПРОГРАММЫ
            //Указатель для доступа к полю, ПОЛЕ это SINGLETON
            Pole mypole = Pole.getInstance();


        //НАЧАЛО ЭВОЛЮЦИОННОГО ЦИКЛА


        //КОНЕЦ ЭВОЛЮЦИОННОГО ЦИКЛА
        }
        public int KolMuraviev(){

            //Указатель для доступа к полю, ПОЛЕ это SINGLETON
            Pole mypole = Pole.getInstance();
            int kolmuraviev = 0;

            //Цикл проверки сколько муравьёв на поле
            for(int i = 0; i < Example.N; i++)
                for (int j = 0; j < Example.N; j++)
                    if ((mypole.pol[i][j].nas != null) || (mypole.pol[i][j].nas != null))
                        kolmuraviev++;
            return kolmuraviev;
        }


        public void actionPerformed(ActionEvent event){
            //Указатель для доступа к полю, ПОЛЕ это SINGLETON
            Pole mypole = Pole.getInstance();

            if(event.getSource() == buttonNachat){

                Example.flashok = true;
                buttonNachat.setEnabled(false);
                buttonStop.setEnabled(true);
                buttonPlusMuravei.setEnabled(false);
                buttonPlusEda.setEnabled(false);
            }
            else
                if(event.getSource() == buttonStop){
                    Example.flashok = false;
                    buttonNachat.setEnabled(true);
                    buttonStop.setEnabled(false);
                    buttonPlusMuravei.setEnabled(true);
                    buttonPlusEda.setEnabled(true);
                }
                    else
                        if(event.getSource() == buttonPlusMuravei){
                            //Проверяем не достигли ли максимального количества муравьёв
                            if(Example.KolMuraviev()<=((Example.N * Example.N)/2))
                            {
                                //Нужно сгенерировать случайную координату
                                int sluchkoordinataX;
                                int sluchkoordinataY;
                                Random random = new Random();

                                //Цикл генерации случайной координаты
                                do {
                                    //Генерирует от 0 до max НЕ включая max, чтобы коорлдината не могла быть 0 прибавим 1
                                    sluchkoordinataX = random.nextInt(Example.N);
                                    sluchkoordinataY = random.nextInt(Example.N);

                                    if(mypole.pol[sluchkoordinataX][sluchkoordinataY].nas == null)
                                    {
                                        mypole.pol[sluchkoordinataX][sluchkoordinataY].nas = new Muravei(sluchkoordinataX,sluchkoordinataY);
                                        mypole.pol[sluchkoordinataX][sluchkoordinataY].flagpererisovki = true;
                                        break;
                                    }

                                } while (true);
                            }
                            Example.frame.repaint();
                        }
                        else
                            if(event.getSource() == buttonPlusEda) {

                            }
        }

    }





class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g) {

        //Указатель для доступа к полю
        Pole mypole = Pole.getInstance();

        //Создаём свои цвета
        Color mycolor1 = new Color(205,154,123);
        Color mycolor2 = new Color(0,255,0);
        g.setColor(mycolor1);

        //Вычисляем ширину и высоту клетки
        int Width = this.getWidth();    //Вычисляем ширину панели
        int Height = this.getHeight();  //Вычисляем высоту панели
        int OtstupWidth = (Width % Example.N)/2;
        int OtstupHeight = (Height % Example.N)/2;
        int shirinakletki = Width / Example.N;
        int visotakletki  = Height  / Example.N;

        //Координаты левого верхнего угла клетки
        int X;
        int Y;

        //Заливаем сразу все поле коричневым цветом чтобы муравьи не рисовались в упор к стенке.
        g.fillRect(0,0,Width,Height);
        
        //Цикл прорисовки поля по клеткам
        for(int i = 0; i < Example.N; i++) {
            for(int j = 0; j < Example.N; j++) {
                if(mypole.pol[i][j].flagpererisovki == true){
                    if (mypole.pol[i][j].nas != null) {
                        mypole.pol[i][j].nas.risovanie(g,shirinakletki,visotakletki,OtstupWidth,OtstupHeight);
                    }
                    else
                        if(mypole.pol[i][j].ed != null) {

                        }
                        else{
                                g.setColor(mycolor1);
                                X = i * shirinakletki + OtstupWidth;
                                Y = j * visotakletki + OtstupHeight;
                                g.fillRect(X, Y, X + shirinakletki, Y + visotakletki);
                            }
                    //mypole.pol[i][j].flagpererisovki = false;
                }
            }
        }
    }
}