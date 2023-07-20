import java.awt.*;

public class Nasekomoe {
    kletka kletk;
    String name;
    public Nasekomoe(){
        kletk = new kletka();
        name = "";
    }
    public void smenasostoania(int X,int Y){
        //Указатель для доступа к полю
        Pole mypole = Pole.getInstance();
        //Pole.pol[X][Y].setKlet();


    }
    public void risovanie(Graphics g, int shirinakletki, int visotakletki){

        g.fillRect(kletk.getKoordinataX(),kletk.koordinataY,shirinakletki,visotakletki);

    }
}
