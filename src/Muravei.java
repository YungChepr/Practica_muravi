import java.awt.*;

public class Muravei extends Nasekomoe{
    Color myraveycolor = new Color(0,255,0);
    public Muravei(int koordinX, int koordinY){
        super(koordinX,koordinY);
    }
    @Override
    public void risovanie(Graphics g, int shirinakletki, int visotakletki,int otstupX, int otstupY){

        int X = kletk.getKoordinataX()*shirinakletki + otstupX;
        int Y = kletk.getKoordinataY()*visotakletki + otstupY;
        g.setColor(myraveycolor);
        g.fillRect(X,Y,shirinakletki,visotakletki);

    }
    @Override
    public void smenasostoania(){

        //Указатель для доступа к полю, ПОЛЕ это SINGLETON
        Pole mypole = Pole.getInstance();

        //Вспомогательные координаты(старые координаты насекомого)
        int VspKoorX = kletk.koordinataX;
        int VspKoorY = kletk.koordinataY;
        //Количество попыток и направление
        int kolpopitok = 0;
        int napr;

        //Насекомое выбыло по старой координате
        mypole.pol[kletk.koordinataX][kletk.koordinataY].setNasekomoe(null);
        mypole.pol[kletk.koordinataX][kletk.koordinataY].flagpererisovki = true;

        do{
            //Попытка
            kolpopitok++;

            //Переменная овечающая за одно из 4 направлений куда может ползти насекомое
            napr = (int)(Math.random() * 4);

            if (napr == 0) {
                if(VspKoorX+1 < Example.N) {
                    if(mypole.pol[VspKoorX+1][VspKoorY].nas == null) {
                        VspKoorX = VspKoorX + 1;
                        break;
                    }
                }
            }
            if (napr == 1) {
                if(VspKoorY+1 < Example.N) {
                    if(mypole.pol[VspKoorX][VspKoorY+1].nas == null) {
                        VspKoorY = VspKoorY + 1;
                        break;
                    }
                }
            }
            if (napr == 2) {
                if(VspKoorX-1 >= 0) {
                    if(mypole.pol[VspKoorX-1][VspKoorY].nas == null) {
                        VspKoorX = VspKoorX - 1;
                        break;
                    }
                }
            }
            if (napr == 3) {
                if(VspKoorY-1 >= 0) {
                    if(mypole.pol[VspKoorX][VspKoorY-1].nas == null) {
                        VspKoorY = VspKoorY - 1;
                        break;
                    }
                }
            }

            //Если превысили допустимое количество попыток двинуться в определённом направлении то выходим из цикла
            if(kolpopitok > 10) break;

        } while(true);

        //Новые координаты для насекомого
        kletk.koordinataX = VspKoorX;
        kletk.koordinataY = VspKoorY;

        //Насекомое прибыло по новой координате
        mypole.pol[kletk.koordinataX][kletk.koordinataY].setNasekomoe(this);
        mypole.pol[kletk.koordinataX][kletk.koordinataY].flagpererisovki = true;

    }

}
