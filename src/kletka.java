
public class kletka extends koordinata {
    Example.sost klet;
    Nasekomoe nas; //Указатель на насекомое, поле будет вызывать его метеоды напрямую
    Eda ed;        //Указатель на еду, поле будет вызывать его метеоды напрямую
    public kletka() {
        super();
        klet = Example.sost.PUST;
        nas = null;
        ed = null;
    }

    public void setKlet(Example.sost klet) {
        this.klet = klet;
    }

    public Example.sost getKlet() {
        return klet;
    }
}

