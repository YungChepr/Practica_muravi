import java.awt.*;

public class Eda {
    kletka kletk;
    Color edacolor = new Color(255,191,0);  //Цвет еды
    Color edacolor2 = new Color(255,255,0); //Цвет поедаемой еды
    Muravei poedanie; //Указатель на муравья который ест еду

    public Eda(int koorX, int koorY){
        kletk = new kletka();
        kletk.setKoordinataX(koorX);
        kletk.setKoordinataY(koorY);
        poedanie = null;
    }
    public void smenasostoania(){

    }
    public void risovanie(Graphics g, int shirinakletki, int visotakletki, int otstupX, int otstupY){

        int X = kletk.getKoordinataX()*shirinakletki + otstupX;
        int Y = kletk.getKoordinataY()*visotakletki + otstupY;
        if(poedanie != null) {
            g.setColor(edacolor2);
        }
        else {
            g.setColor(edacolor);
        }
        g.fillRect(X,Y,shirinakletki,visotakletki);

    }
}
