import javax.swing.*;

//Класс для хранения злужебных переменных
public class Example {
    public static  int N = 100;
    public static boolean flashok = false;
    public static JFrame frame;
    public static int KolMuraviev(){

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

}
