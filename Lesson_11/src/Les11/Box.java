package Les11;


import java.util.ArrayList;
import java.util.Arrays;


public class Box<T extends Fruit> {

    String name;
    int capacity;
    ArrayList<Float> fruitsInBox;


    public Box(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        fruitsInBox = new ArrayList<Float>();
    }


    public void addFruit(T fruit) {
        fruitsInBox.add(fruit.getWeight());
    }

    public ArrayList<Float> getFruitsInBox() {
        return fruitsInBox;
    }


    public float getWeight() {
        float sum = 0;
        for (int i = 0; i < fruitsInBox.size(); i++) {
            sum += fruitsInBox.get(i);
        }
        System.out.println("Масса коробки " + this.name + " равна " + sum);
        return sum;
    }


    public boolean compare(Box<? extends Fruit> nextBox) {
        if (this.getWeight() == nextBox.getWeight()) {
            System.out.println("Массы коробок " + this.name + " и " + nextBox.name + " равны");
            return true;
        } else System.out.println("Массы коробок " + this.name + " и " + nextBox.name + " отличаются");
        return false;
    }


    public void replaceToOtherBox(Box<T> newBox) {

        int k = this.fruitsInBox.size();

        for (int i = 0; i < k; i++) {

            newBox.fruitsInBox.add(this.fruitsInBox.get(0));
            this.fruitsInBox.remove(0);

        }
        System.out.println("Пересыпали содержимое из старой коробки " + this.name + " в новую коробку " + newBox.name);
        System.out.println("Содержимое старой коробки: " + this.fruitsInBox + ", содержимое новой коробки " + newBox.fruitsInBox);
    }

}
