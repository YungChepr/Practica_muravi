public class koordinata {
    int koordinataX;
    int koordinataY;
    public koordinata() {
        koordinataX = -1;
        koordinataY = -1;
    }

    public void setKoordinataX(int koordinataX) {
        // проверка на коректность переданной значения координат. Она должна быть от 0 до N. todo
        // СДЕЛАТЬ!!!
        this.koordinataX = koordinataX;
    }

    public void setKoordinataY(int koordinataY) {
        // И ТУТ СДЕЛАТЬ ТОЖЕ!!!
        this.koordinataY = koordinataY;
    }

    public int getKoordinataX() {
        return koordinataX;
    }

    public int getKoordinataY() {
        return koordinataY;
    }
}
