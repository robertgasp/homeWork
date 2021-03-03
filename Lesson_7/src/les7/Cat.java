package les7;


import java.util.ArrayList;

public class Cat {

    private String name;
    private int sytost;//сытость в %
    private int emkost_kota;//емкость кота-степень голода=столько сможет съесть
    private int skolko_syel;
    private int skolko_ostalos = 0;

    public static ArrayList<Cat> cats = new ArrayList<>();


    public Cat(String name, int sytost, int emkost_kota) {
        this.name = name;
        this.sytost = sytost;
        this.emkost_kota = emkost_kota;
        cats.add(this);
    }

    public int getSytost() {
        return sytost;
    }

    public void setSytost(int sytost) {
        this.sytost = sytost;
    }

    public int getEmkost_kota() {
        return emkost_kota;
    }


    public int getSkolko_syel() {
        this.skolko_syel = this.emkost_kota - ((this.emkost_kota * this.sytost) / 100); //результат будет приближенным с округлением
        return this.skolko_syel;
    }

    public void catEats(Plate plate) {

        skolko_ostalos = plate.getSkolkoEdy();

        if ((skolko_ostalos - this.getSkolko_syel()) > 0 && !(this.emkost_kota == this.sytost)) {
            skolko_ostalos = skolko_ostalos - this.getSkolko_syel();
            plate.setSkolkoEdy(skolko_ostalos);
            System.out.println(this.name + " подошел к миске и и съел " + this.getSkolko_syel() + " г корма. В тарелке осталось " + skolko_ostalos + " г корма.");
            this.setSytost(this.getEmkost_kota());
        } else
            System.out.println("В тарелке недостаточно корма для " + this.name + ", котик остался голодным, добавьте еды.");
    }


    public static void catsInfo() {

        for (int i = 0; i < Cat.cats.size(); i++) {
            if (cats.get(i).getEmkost_kota() == cats.get(i).getSytost()) {
                System.out.println("Кот " + cats.get(i).name + " насытился, теперь он мирно спит на диване.");
            } else {
                System.out.println("Кот " + cats.get(i).name + " остался голодным и громко мяукает, требуя еду.");
            }
        }

    }
}
