package les7;

public class Lesson_7 {

    public static void main(String[] args) {

        Cat catBarsik = new Cat("Барсик", 35, 100);//указываем сытость в %
        Cat catBoris = new Cat("Борис", 70, 140);
        Cat catFenya = new Cat("Феня", 10, 150);
        Cat catGannibal = new Cat("Ганнибал", 90, 100);

        Plate plate = new Plate(200, 200);


        catBarsik.catEats(plate);
        catBoris.catEats(plate);
        catFenya.catEats(plate);
        catGannibal.catEats(plate);

        plate.giveFood(10);

        Cat.catsInfo();
    }
}
