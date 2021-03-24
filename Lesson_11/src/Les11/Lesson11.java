package Les11;


public class Lesson11 {

    public static void main(String[] args) {

        String[] str = {"Hello, ", "World! ", "I's ", "a nice day!"};

        exercise1();
        System.out.println();

        exercise2(str);
        System.out.println();

        exercise3();
    }


    private static void exercise1() {
        ChangeArray<Integer> arr1 = new ChangeArray<Integer>(2, 1);
        arr1.replaceIndex();
        arr1.outReplacedIndex();
    }

    private static void exercise2(String[] str) {
        ToArrayList<String> arr2 = new ToArrayList<String>();
        arr2.toArrayList(str);
    }


    private static void exercise3() {
        float appleWeight = 1.0f;
        float orangeWeight = 1.5f;

        Apple apple1 = new Apple("Apple1", appleWeight);
        Apple apple2 = new Apple("Apple2", appleWeight);
        Apple apple3 = new Apple("Apple3", appleWeight);
        Apple apple4 = new Apple("Apple4", appleWeight);

        Orange orange1 = new Orange("Orange1", orangeWeight);
        Orange orange2 = new Orange("Orange2", orangeWeight);
        Orange orange3 = new Orange("Orange3", orangeWeight);
        Orange orange4 = new Orange("Orange4", orangeWeight);

        Box<Orange> boxForOranges = new Box("BoxForOranges", 15);
        Box<Orange> boxForOranges2 = new Box("BoxForOranges 2", 15);
        Box<Apple> boxForApples = new Box("BoxForApples", 10);

        boxForApples.addFruit(apple1);
        boxForApples.addFruit(apple2);
        boxForApples.addFruit(apple3);
        boxForApples.addFruit(apple4);

        boxForOranges.addFruit(orange1);
        boxForOranges.addFruit(orange2);
        boxForOranges.addFruit(orange3);
        boxForOranges.addFruit(orange4);

        boxForApples.compare(boxForOranges);

        boxForOranges.replaceToOtherBox(boxForOranges2);
        boxForOranges2.getWeight();
    }
}
