import java.awt.*;

public class Muravei extends Nasekomoe{
    Color myraveycolor = new Color(0,255,0);
    public Muravei(){

    }
    @Override
    public void risovanie(Graphics g, int shirinakletki, int visotakletki){

        g.setColor(myraveycolor);
        g.fillRect(kletk.getKoordinataX(),kletk.koordinataY,shirinakletki,visotakletki);

    }
    public int dvishenie(){
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
