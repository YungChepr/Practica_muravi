import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Panel1 gui = new Panel1();
        gui.go();
    }
}

class Panel1 {
    public void go() {

        //Создаём фрейм и панели
        JFrame frame = new JFrame();
        MyDrawPanel mypanel = new MyDrawPanel();
        //JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        //Устанавливаем цвет для первой панели
        //mypanel.setBackground(Color.getHSBColor(165, 42, 42));
        //Устанавливаем режим компоновки для второй панели и пятой
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

        //Создаём кнопки
        JButton buttonPlusEda = new JButton("+ ЕДА");
        JButton buttonPlusMuravei = new JButton("+ МУРАВЕЙ");
        JButton buttonNachat = new JButton("НАЧАТЬ");
        JButton buttonStop = new JButton("СТОП");

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
        //frame.pack();
        //frame.setSize(1920, 1080);
        //frame.setSize(new Dimension(800, 600));
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);


    }
}
class MyDrawPanel extends JPanel{
    public void paintComponent(Graphics g) {
        int Width = this.getWidth();    //Вычисляем высоту панели
        int Height = this.getHeight();  //Вычисляем ширину панели
        Pole mypole; //Указатель на объект класса Pole
        Color mycolor1 = new Color(205,154,123);
        Color mycolor2 = new Color(0,255,0);
        g.setColor(mycolor1);
        //g.fillRect(0,0,this.getWidth(), this.getHeight());

        int visotakletki  = Width  / Example.N;
        int shirinakletki = Height / Example.N;

        for(int i = 0; i < Example.N; i++) {
            for(int j = 0; j < Example.N; j++) {
                mypole = Pole.getInstance();
                //mypole.chistka();
                if (mypole.pol[i][j].getKlet() == Example.sost.MUR) {
                    g.setColor(mycolor2);
                    g.fillRect(mypole.pol[i][j].getKoordinataX(), mypole.pol[i][j].getKoordinataY(), (mypole.pol[i][j].getKoordinataX() + visotakletki), (mypole.pol[i][j].getKoordinataY() + shirinakletki));
                    g.setColor(mycolor1);
                }
                else {
                    g.fillRect(mypole.pol[i][j].getKoordinataX(), mypole.pol[i][j].getKoordinataY(), (mypole.pol[i][j].getKoordinataX() + visotakletki), (mypole.pol[i][j].getKoordinataY() + shirinakletki));
                }
            }
        }
        //Dimension size = this.getSize();


    }
}