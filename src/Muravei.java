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
    public int smenasostoania(){
        int koordinata;

        int napr = (int)(Math.random() * 4);
        if (napr == 0) {
            koordinata = kletk.getKoordinataX()+1;
            kletk.setKoordinataX(koordinata);
        }
        if (napr == 1) {
            koordinata = kletk.getKoordinataY()+1;
            kletk.setKoordinataY(koordinata);
        }
        if (napr == 2) {
            koordinata = kletk.getKoordinataX()-1;
            kletk.setKoordinataX(koordinata);
        }
        if (napr == 3) {
            koordinata = kletk.getKoordinataY()-1;
            kletk.setKoordinataY(koordinata);
        }
        return napr;
    }

}
