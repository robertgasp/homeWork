package Les6;

public class Lesson_6 {

    private final static int dog_dist = 500;
    private final static int dog_swim = 10;
    private final static int cat_dist = 200;

    public static void main(String[] args) {

        Cat catBoris = new Cat("Борис", "пятнистый", cat_dist);
        Cat catSheba = new Cat("Шеба", "дымчатая", cat_dist);
        Cat catTasya = new Cat("Тася", "бежевая", cat_dist);
        Cat catVasya = new Cat("Вася", "белый", cat_dist);

        Dog dogTuzik = new Dog("Тузик", "черный", dog_dist, dog_swim);
        Dog dogDruzok = new Dog("Дружок", "бежевый", dog_dist, dog_swim);
        Dog dogBobik = new Dog("Бобик", "пятнистый", dog_dist, dog_swim);
        Dog dogPolkan = new Dog("Полкан", "коричневый", dog_dist, dog_swim);

        catBoris.run(200);
        catSheba.run(300);
        catTasya.run(50);
        catVasya.swim(50);

        dogTuzik.swim(10);
        dogBobik.swim(100);

        dogDruzok.run(700);
        dogPolkan.run(500);

        Animals.animalsCount();
    }

}
