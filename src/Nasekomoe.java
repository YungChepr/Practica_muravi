import java.awt.*;

public class Nasekomoe {
    kletka kletk;
    String name;
    public Nasekomoe(int koorX, int koorY){
        kletk = new kletka();
        kletk.setKoordinataX(koorX);
        kletk.setKoordinataY(koorY);
        name = "";
    }
    public int smenasostoania(){
        //Указатель для доступа к полю
        Pole mypole = Pole.getInstance();
        //Pole.pol[X][Y].setKlet();

        return 0;
    }
    public void risovanie(Graphics g, int shirinakletki, int visotakletki,int otstupX, int otstupY){


        //g.fillRect(kletk.getKoordinataX(),kletk.koordinataY,shirinakletki,visotakletki);

    }
}
