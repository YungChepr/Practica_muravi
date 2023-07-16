
public class kletka extends koordinata {
    Example.sost klet;
    public kletka() {
        super();
        klet = Example.sost.PUST;
    }

    public void setKlet(Example.sost klet) {
        this.klet = klet;
    }

    public Example.sost getKlet() {
        return klet;
    }
}

