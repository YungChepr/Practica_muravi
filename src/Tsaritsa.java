import java.awt.*;
import java.util.Random;

public class Tsaritsa extends Muravei{
    Color tsaritsacolor = new Color(235,35,35); //Цвет царицы
    public Tsaritsa(int koordinX, int koordinY){
        super(koordinX,koordinY);
        LifePower = Example.MaxLifePower;
    }
    @Override
    public void risovanie(Graphics g, int shirinakletki, int visotakletki,int otstupX, int otstupY){

        int X = kletk.getKoordinataX()*shirinakletki + otstupX;
        int Y = kletk.getKoordinataY()*visotakletki + otstupY;
        if(LifePower < Example.MinLifePower){
            g.setColor(myraveycolor2);
        }
        else {

            g.setColor(tsaritsacolor);

        }
        g.fillRect(X, Y, shirinakletki, visotakletki);
    }
    public void born()
    {
        //Проверяем не достигли ли максимального количества муравьёв
        if(Example.KolMuraviev()<=((Example.N * Example.N)/2)) {

            //Указатель для доступа к полю
            Pole mypole = Pole.getInstance();

            //Вспомогательные координаты(старые координаты насекомого)
            int VspKoorX = kletk.koordinataX;
            int VspKoorY = kletk.koordinataY;

            //Если рядом есть свободные поля пробуем ставить муравья на них
            if ((VspKoorX + 1) < Example.N) {
                if ((mypole.pol[VspKoorX + 1][VspKoorY].nas == null) && (mypole.pol[VspKoorX + 1][VspKoorY].ed == null)) {
                    mypole.pol[VspKoorX + 1][VspKoorY].nas = new Egg(VspKoorX + 1, VspKoorY);
                    mypole.pol[VspKoorX + 1][VspKoorY].flagpererisovki = true;

                }
            } else {
                if((VspKoorY+1)<Example.N) {
                    if ((mypole.pol[VspKoorX][VspKoorY + 1].nas == null) && (mypole.pol[VspKoorX][VspKoorY + 1].ed == null)) {
                        mypole.pol[VspKoorX][VspKoorY+1].nas = new Egg(VspKoorX, VspKoorY+1);
                        mypole.pol[VspKoorX][VspKoorY+1].flagpererisovki = true;
                    }
                } else {
                    if((VspKoorX-1)>=0){
                        if((mypole.pol[VspKoorX-1][VspKoorY].nas == null) && (mypole.pol[VspKoorX-1][VspKoorY].ed == null)) {
                            mypole.pol[VspKoorX - 1][VspKoorY].nas = new Egg(VspKoorX - 1, VspKoorY);
                            mypole.pol[VspKoorX - 1][VspKoorY].flagpererisovki = true;
                            }
                        } else {
                        if((VspKoorY-1)>=0) {
                            if ((mypole.pol[VspKoorX][VspKoorY - 1].nas == null) && (mypole.pol[VspKoorX][VspKoorY - 1].ed == null)) {
                                mypole.pol[VspKoorX][VspKoorY-1].nas = new Egg(VspKoorX, VspKoorY-1);
                                mypole.pol[VspKoorX][VspKoorY-1].flagpererisovki = true;
                                }
                            } else {
                            //Если не получилось то пока не придумал
                        }
                    }
                }
            }
        }
        Example.frame.repaint();
    }


    @Override
    public void smenasostoania(){

        //Указатель для доступа к полю, ПОЛЕ это SINGLETON
        Pole mypole = Pole.getInstance();

        //Вспомогательные координаты(старые координаты насекомого)
        int VspKoorX = kletk.koordinataX;
        int VspKoorY = kletk.koordinataY;

        //Количество попыток и направление
        int kolpopitok = 0;
        int napr = 0;

        if(LifePower >= Example.MinLifePower){

            //Проверка еды
            if((VspKoorX+1)<Example.N){
                if(mypole.pol[VspKoorX+1][VspKoorY].ed != null){
                    if(mypole.pol[VspKoorX+1][VspKoorY].ed.poedanie == null) {
                        mypole.pol[VspKoorX+1][VspKoorY].ed.poedanie = this;
                        //Муравей ест еду 10 тактов
                        if (vremyapoedanie > 10) {
                            vremyapoedanie = 0;
                            mypole.pol[VspKoorX + 1][VspKoorY].setEda(null);
                            mypole.pol[VspKoorX + 1][VspKoorY].flagpererisovki = true;

                            //Если жизненная сила будет больше макс то сделать ее макс
                            if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                LifePower = Example.MaxLifePower;
                            }
                            //А если нет то прибавляем естественным путём
                            else {
                                LifePower = LifePower + Example.LifePower;
                            }
                            born();
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                            vremyapoedanie++;
                        }
                    }
                    //Если это тот муравей который начал есть еду
                    else {
                        if (mypole.pol[VspKoorX + 1][VspKoorY].ed.poedanie == this) {
                            if (vremyapoedanie > 10) {
                                vremyapoedanie = 0;
                                mypole.pol[VspKoorX + 1][VspKoorY].setEda(null);
                                mypole.pol[VspKoorX + 1][VspKoorY].flagpererisovki = true;
                                //Если жизненная сила будет больше макс то сделать ее макс
                                if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                    LifePower = Example.MaxLifePower;
                                }
                                //А если нет то прибавляем естественным путём
                                else {
                                    LifePower = LifePower + Example.LifePower;
                                }
                                born();
                            } else {
                                napravlenie = Example.Napravlenie.STAY;
                                vremyapoedanie++;
                            }

                        }
                        else {
                            //Ничего не происходит
                        }
                    }
                }
            }
            if((VspKoorY+1)<Example.N){
                if(mypole.pol[VspKoorX][VspKoorY+1].ed != null){
                    if(mypole.pol[VspKoorX][VspKoorY+1].ed.poedanie == null) {
                        mypole.pol[VspKoorX][VspKoorY+1].ed.poedanie = this;
                        //Муравей ест еду 10 тактов
                        if (vremyapoedanie > 10) {
                            vremyapoedanie = 0;
                            mypole.pol[VspKoorX][VspKoorY+1].setEda(null);
                            mypole.pol[VspKoorX][VspKoorY+1].flagpererisovki = true;
                            //Если жизненная сила будет больше макс то сделать ее макс
                            if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                LifePower = Example.MaxLifePower;
                            }
                            //А если нет то прибавляем естественным путём
                            else {
                                LifePower = LifePower + Example.LifePower;
                            }
                            born();
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                            vremyapoedanie++;
                        }
                    }
                    //Если это тот муравей который начал есть еду
                    else {
                        if (mypole.pol[VspKoorX][VspKoorY+1].ed.poedanie == this) {
                            if (vremyapoedanie > 10) {
                                vremyapoedanie = 0;
                                mypole.pol[VspKoorX][VspKoorY+1].setEda(null);
                                mypole.pol[VspKoorX][VspKoorY+1].flagpererisovki = true;
                                //Если жизненная сила будет больше макс то сделать ее макс
                                if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                    LifePower = Example.MaxLifePower;
                                }
                                //А если нет то прибавляем естественным путём
                                else {
                                    LifePower = LifePower + Example.LifePower;
                                }
                                born();
                            } else {
                                napravlenie = Example.Napravlenie.STAY;
                                vremyapoedanie++;
                            }
                        }
                        else {
                            //Ничего не происходит
                        }
                    }
                }
            }
            if((VspKoorX-1)>=0){
                if(mypole.pol[VspKoorX-1][VspKoorY].ed != null){
                    if(mypole.pol[VspKoorX-1][VspKoorY].ed.poedanie == null) {
                        mypole.pol[VspKoorX-1][VspKoorY].ed.poedanie = this;
                        //Муравей ест еду 10 тактов
                        if (vremyapoedanie > 10) {
                            vremyapoedanie = 0;
                            mypole.pol[VspKoorX - 1][VspKoorY].setEda(null);
                            mypole.pol[VspKoorX - 1][VspKoorY].flagpererisovki = true;
                            //Если жизненная сила будет больше макс то сделать ее макс
                            if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                LifePower = Example.MaxLifePower;
                            }
                            //А если нет то прибавляем естественным путём
                            else {
                                LifePower = LifePower + Example.LifePower;
                            }
                            born();
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                            vremyapoedanie++;
                        }
                    }
                    //Если это тот муравей который начал есть еду
                    else {
                        if (mypole.pol[VspKoorX - 1][VspKoorY].ed.poedanie == this) {
                            if (vremyapoedanie > 10) {
                                vremyapoedanie = 0;
                                mypole.pol[VspKoorX - 1][VspKoorY].setEda(null);
                                mypole.pol[VspKoorX - 1][VspKoorY].flagpererisovki = true;
                                //Если жизненная сила будет больше макс то сделать ее макс
                                if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                    LifePower = Example.MaxLifePower;
                                }
                                //А если нет то прибавляем естественным путём
                                else {
                                    LifePower = LifePower + Example.LifePower;
                                }
                                born();
                            } else {
                                napravlenie = Example.Napravlenie.STAY;
                                vremyapoedanie++;
                            }

                        }
                        else {
                            //Ничего не происходит
                        }
                    }
                }
            }
            if((VspKoorY-1)>=0){
                if(mypole.pol[VspKoorX][VspKoorY-1].ed != null){
                    if(mypole.pol[VspKoorX][VspKoorY-1].ed.poedanie == null) {
                        mypole.pol[VspKoorX][VspKoorY-1].ed.poedanie = this;
                        //Муравей ест еду 10 тактов
                        if (vremyapoedanie > 10) {
                            vremyapoedanie = 0;
                            mypole.pol[VspKoorX][VspKoorY-1].setEda(null);
                            mypole.pol[VspKoorX][VspKoorY-1].flagpererisovki = true;
                            //Если жизненная сила будет больше макс то сделать ее макс
                            if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                LifePower = Example.MaxLifePower;
                            }
                            //А если нет то прибавляем естественным путём
                            else {
                                LifePower = LifePower + Example.LifePower;
                            }
                            born();
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                            vremyapoedanie++;
                        }
                    }
                    //Если это тот муравей который начал есть еду
                    else {
                        if (mypole.pol[VspKoorX][VspKoorY-1].ed.poedanie == this) {
                            if (vremyapoedanie > 10) {
                                vremyapoedanie = 0;
                                mypole.pol[VspKoorX][VspKoorY-1].setEda(null);
                                mypole.pol[VspKoorX][VspKoorY-1].flagpererisovki = true;
                                //Если жизненная сила будет больше макс то сделать ее макс
                                if((LifePower + Example.LifePower)>Example.MaxLifePower){
                                    LifePower = Example.MaxLifePower;
                                }
                                //А если нет то прибавляем естественным путём
                                else {
                                    LifePower = LifePower + Example.LifePower;
                                }
                                born();
                            } else {
                                napravlenie = Example.Napravlenie.STAY;
                                vremyapoedanie++;
                            }
                        }
                        else {
                            //Ничего не происходит
                        }
                    }
                }
            }

            if(vremyapoedanie == 0) {

                //Каждый такт муравей теряет жизненную силу
                LifePower--;

                //Цикл движения муравья
                do {
                    //Попытка
                    kolpopitok++;

                    //Переменная овечающая за одно из 4 направлений куда может ползти насекомое
                    if (napravlenie == Example.Napravlenie.STAY) {
                        napr = 1 + (int) (Math.random() * ((4 - 1) + 1));
                    }
                    if (napravlenie == Example.Napravlenie.RIGHT) napr = 1;
                    if (napravlenie == Example.Napravlenie.BOTTOM) napr = 2;
                    if (napravlenie == Example.Napravlenie.LEFT) napr = 3;
                    if (napravlenie == Example.Napravlenie.TOP) napr = 4;

                    if (napr == 1) {
                        if ((VspKoorX + 1) < Example.N) {
                            if ((mypole.pol[VspKoorX + 1][VspKoorY].nas == null) && (mypole.pol[VspKoorX + 1][VspKoorY].ed == null)) {
                                napravlenie = Example.Napravlenie.RIGHT;
                                VspKoorX = VspKoorX + 1;
                                break;
                            }
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                        }
                    }
                    if (napr == 2) {
                        if ((VspKoorY + 1) < Example.N) {
                            if ((mypole.pol[VspKoorX][VspKoorY + 1].nas == null) && (mypole.pol[VspKoorX][VspKoorY + 1].ed == null)) {
                                napravlenie = Example.Napravlenie.BOTTOM;
                                VspKoorY = VspKoorY + 1;
                                break;
                            }
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                        }
                    }
                    if (napr == 3) {
                        if ((VspKoorX - 1) >= 0) {
                            if ((mypole.pol[VspKoorX - 1][VspKoorY].nas == null) && (mypole.pol[VspKoorX - 1][VspKoorY].ed == null)) {
                                napravlenie = Example.Napravlenie.LEFT;
                                VspKoorX = VspKoorX - 1;
                                break;
                            }
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                        }
                    }
                    if (napr == 4) {
                        if ((VspKoorY - 1) >= 0) {
                            if ((mypole.pol[VspKoorX][VspKoorY - 1].nas == null) && (mypole.pol[VspKoorX][VspKoorY - 1].ed == null)) {
                                napravlenie = Example.Napravlenie.TOP;
                                VspKoorY = VspKoorY - 1;
                                break;
                            }
                        } else {
                            napravlenie = Example.Napravlenie.STAY;
                        }
                    }

                    //Если превысили допустимое количество попыток двинуться в определённом направлении то выходим из цикла
                    if (kolpopitok > 10) {
                        napravlenie = Example.Napravlenie.STAY;
                        break;
                    }

                } while (true);

                //Насекомое выбыло по старой координате
                mypole.pol[kletk.koordinataX][kletk.koordinataY].setNasekomoe(null);
                mypole.pol[kletk.koordinataX][kletk.koordinataY].flagpererisovki = true;

                //Новые координаты для насекомого
                kletk.koordinataX = VspKoorX;
                kletk.koordinataY = VspKoorY;

                //Насекомое прибыло по новой координате
                mypole.pol[kletk.koordinataX][kletk.koordinataY].setNasekomoe(this);
                mypole.pol[kletk.koordinataX][kletk.koordinataY].flagpererisovki = true;
                tronuto = true;
            }
        }
        else {
            napravlenie = Example.Napravlenie.STAY;
            LifePower--;
            if(LifePower < 1){
                //Насекомое выбыло по старой координате
                mypole.pol[kletk.koordinataX][kletk.koordinataY].setNasekomoe(null);
                mypole.pol[kletk.koordinataX][kletk.koordinataY].flagpererisovki = true;
            }
        }
    }

}
