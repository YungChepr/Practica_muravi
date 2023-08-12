
public class kletka extends koordinata {
    Nasekomoe nas; //Указатель на насекомое, поле будет вызывать его метеоды напрямую
    Eda ed;        //Указатель на еду, поле будет вызывать его метеоды напрямую
    boolean flagpererisovki; //Флажок указывающий надо перерисовывать поле или нет
    public kletka() {
        super();
        nas = null;
        ed = null;
        flagpererisovki = true;
    }

    public void setNasekomoe(Nasekomoe nas) {
        this.nas = nas;
    }
    public Nasekomoe getNasekomoe() {
        return nas;
    }
    public void setEda(Eda nas) {
        this.ed = ed;
    }
    public Eda getEda() {
        return ed;
    }
}

