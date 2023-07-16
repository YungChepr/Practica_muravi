public class Pole {
    private static Pole instance;
    private Pole(){
        for (int i = 0; i < Example.N; i++) {
            for (int j = 0; j < Example.N; j++) {
                pol[i][j] = new kletka();
            }
        }
        chistka();
    }
    public static Pole getInstance(){
        if (instance == null){
            instance = new Pole();
        }
        return instance;
    }
    kletka [][] pol = new kletka[Example.N][Example.N];
    public void chistka() {
        for (int i = 0; i < Example.N; i++) {
            for (int j = 0; j < Example.N; j++) {
                pol[i][j].setKlet(Example.sost.PUST);
                pol[i][j].setKoordinataX(i);
                pol[i][j].setKoordinataY(j);
            }
        }
    }

}

