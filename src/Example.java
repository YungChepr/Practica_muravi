import javax.swing.*;

//Класс для хранения злужебных переменных
public class Example {
    public static  int N = 30; //Размерность поля
    public static  int Tact = 10; //Время такта в милисекундах
    public static  int LifePower = 5 * N; //Жизненная сила муравья в тактах
    public static  int MaxLifePower = 10 * N; //Максимальная жизненная сила
    public static  int MinLifePower = N/2; //Минимальная жизненная сила

    //Переменные которые нужны глобальными
    public static boolean flashok = false;
    public static JFrame frame;
    public static JTextField textfield1;
    public static JTextField textfield2;
    public static JTextField textfield3;

    //Метод считает количество муравьев на поле
    public static int KolMuraviev(){

        //Указатель для доступа к полю, ПОЛЕ это SINGLETON
        Pole mypole = Pole.getInstance();
        int kolmuraviev = 0;

        //Цикл проверки сколько муравьёв на поле
        for(int i = 0; i < Example.N; i++)
            for (int j = 0; j < Example.N; j++)
                if (mypole.pol[i][j].nas != null)
                    kolmuraviev++;
        return kolmuraviev;
    }

    //Метод считает количество еды на поле
    public static int KolEdi(){

        //Указатель для доступа к полю, ПОЛЕ это SINGLETON
        Pole mypole = Pole.getInstance();
        int koledi = 0;

        //Цикл проверки сколько еды на поле
        for(int i = 0; i < Example.N; i++)
            for (int j = 0; j < Example.N; j++)
                if (mypole.pol[i][j].ed != null)
                    koledi++;
        return koledi;
    }

    //Метод считает количество цариц на поле
    public static int KolTsarits() {

        //Указатель для доступа к полю, ПОЛЕ это SINGLETON
        Pole mypole = Pole.getInstance();
        int koltsarits = 0;

        //Цикл проверки сколько муравьёв на поле
        for (int i = 0; i < Example.N; i++)
            for (int j = 0; j < Example.N; j++)
                if (mypole.pol[i][j].nas != null)
                    if (mypole.pol[i][j].nas instanceof Tsaritsa)
                        koltsarits++;
        return koltsarits;
    }

    //Перечисление содержит варианты направления
    public static enum Napravlenie{
        STAY,
        RIGHT,
        BOTTOM,
        LEFT,
        TOP
    }
}
