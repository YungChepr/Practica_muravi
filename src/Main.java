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

        //Создаём фрейм и 2 панели
        JFrame frame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        //Устанавливаем цвет для первой панели
        panel1.setBackground(Color.getHSBColor(165, 42, 42));
        //Устанавливаем режим компоновки для второй панели
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));

        //Создаём кнопки
        JButton buttonPlusEda = new JButton("+ ЕДА");
        JButton buttonPlusMuravei = new JButton("+ МУРАВЕЙ"); //todo
        JButton buttonNachat = new JButton("НАЧАТЬ");
        JButton buttonStop = new JButton("СТОП");

        //Создаём тектовые поля
        JTextField text1 = new JTextField(20);
        JTextField text2 = new JTextField(20);
        JLabel text3 = new JLabel();
        JLabel text4 = new JLabel();
        text1.setText(" 0");
        text2.setText(" 0");
        text3.setText("Количество еды:");
        text4.setText("Количество муравьев:");

        //Добавляем кнопки на вторую панель
        panel2.add(buttonPlusEda);
        panel2.add(buttonPlusMuravei);
        panel2.add(buttonNachat);
        panel2.add(buttonStop);

        //Добавляем тектовые поля на 3 и 4 панель
        panel3.add(text3);
        panel3.add(text1);
        panel4.add(text4);
        panel4.add(text2);
        panel5.add(panel3);
        panel5.add(panel4);

        //Добавляем панели на фрейм
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        frame.getContentPane().add(BorderLayout.EAST, panel5);
        frame.getContentPane().add(BorderLayout.CENTER, panel1);


        //Устанавливаем размер фрейма делаем его видимым и завершаем работу программы при закрытии окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
}
