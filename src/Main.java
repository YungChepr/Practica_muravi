import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }
}

     class Panel1 implements ActionListener{
        JButton buttonPlusEda;
        JButton buttonPlusMuravei;
        JButton buttonNachat;
        JButton buttonStop;
        public void go() {
        //СОЗДАЮТСЯ ВИЗУАЛЬНЫЕ КОМПОНЕНТЫ
            //Создаём фрейм и панели
            JFrame frame = new JFrame();
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
            buttonNachat = new JButton("НАЧАТЬ");
            buttonStop = new JButton("СТОП");

            //Создаю обработчики событий для кнопок
            buttonPlusEda.addActionListener(this);
            buttonPlusMuravei.addActionListener(this);
            buttonNachat.addActionListener(this);
            buttonStop.addActionListener(this);

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
            frame.getContentPane().add(BorderLayout.WEST, panel2);
            frame.getContentPane().add(BorderLayout.EAST, panel5);
            frame.getContentPane().add(BorderLayout.CENTER, mypanel);



            //Устанавливаем размер фрейма делаем его видимым и завершаем работу программы при закрытии окна
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);



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
                    if ((mypole.pol[i][j].getKlet() == Example.sost.MUR) || (mypole.pol[i][j].getKlet() == Example.sost.MURIZERNO))
                        kolmuraviev++;
            return kolmuraviev;
        }


        public void actionPerformed(ActionEvent event){

            //Указатель для доступа к полю, ПОЛЕ это SINGLETON
            Pole mypole = Pole.getInstance();

            if(event.getSource() == buttonNachat){
                //frame.repaint();
                buttonNachat.setText("ПОЕХАЛИ!");
            }
            else
                if(event.getSource() == buttonPlusMuravei){
                    //Проверяем не достигли ли максимального количества муравьёв
                    if(KolMuraviev()<=((Example.N * Example.N)/2))
                    {
                        //Нужно сгенерировать случайную координату
                       int sluchkoordinataX = 56;
                       int sluchkoordinataY = 56;

                        //Нужно сделать цикл проверки клеток на наличие муравья
                       if((mypole.pol[sluchkoordinataX][sluchkoordinataY].getKlet() != Example.sost.MUR) && (mypole.pol[sluchkoordinataX][sluchkoordinataY].getKlet() != Example.sost.MURIZERNO))
                       {
                           mypole.pol[sluchkoordinataX][sluchkoordinataY].nas = new Muravei();
                           //Если есть еще и зерно
                           mypole.pol[sluchkoordinataX][sluchkoordinataY].setKlet(Example.sost.MUR);

                       }
                    }
                }
                else
                    if(event.getSource() == buttonPlusEda){

                    }
                    else
                        if(event.getSource() == buttonStop){

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
        int shirinakletki = Width / Example.N;
        int visotakletki  = Height  / Example.N;

        //Координаты левого верхнего угла клетки
        int X;
        int Y;

        //Цикл прорисовки поля по клеткам
        for(int i = 0; i < Example.N; i++) {
            for(int j = 0; j < Example.N; j++) {

                if (mypole.pol[i][j].getKlet() == Example.sost.MUR) {
                    g.setColor(mycolor2);

                    X = i*shirinakletki;
                    Y = j*visotakletki;

                    g.fillRect(X,Y,X+shirinakletki,Y+visotakletki);

                    g.setColor(mycolor1);
                }
                else
                    if(mypole.pol[i][j].getKlet() == Example.sost.ZERNO) {

                    }
                    else
                        if(mypole.pol[i][j].getKlet() == Example.sost.MURIZERNO){

                        }
                        else {
                            X = i * shirinakletki;
                            Y = j * visotakletki;
                            g.fillRect(X, Y, X + shirinakletki, Y + visotakletki);

                        }
            }
        }
        //Dimension size = this.getSize();

    }
}