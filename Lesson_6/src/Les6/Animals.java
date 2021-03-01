package Les6;

import java.util.ArrayList;

public abstract class Animals {

    private String name;
    private String color;
    private int run_dist;
    private int swim_dist;
    public static ArrayList<Animals> animals = new ArrayList<>();
    static int countCats;
    static int countDogs;


    public Animals(String name, String color, int run_dist, int swim_dist) {
        this.name = name;
        this.color = color;
        this.run_dist = run_dist;
        this.swim_dist = swim_dist;

        animals.add(this);
    }


    public Animals(String name, String color, int run_dist) {
        this.name = name;
        this.color = color;
        this.run_dist = run_dist;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    protected void run(int dist_for_run) {
        if (dist_for_run <= run_dist) {
            System.out.println(this.color + " " + this.name + " пробежал(a) " + run_dist + " м");
        } else
            System.out.println(this.color + " " + this.name + " не хочет бежать " + dist_for_run + " м, прикажите пробежать меньше (не больше " + run_dist + " м). Собаки здесь очень ленивые");
    }

    public void swim(int dist_for_swim) {
        if (dist_for_swim <= swim_dist) {
            System.out.println(this.color + " " + this.name + " проплыл(a) " + swim_dist + " м");
        } else {
            System.out.println(this.color + " " + this.name + " не хочет плыть " + swim_dist + " м, прикажите проплыть меньшую дистанцию (не больше " + swim_dist + " м)");
        }
    }

    public static void animalsCount() {

        for (int i = 0; i < animals.size(); i++) {

            if (animals.get(i).getClass() == Cat.class) {
                countCats++;
            } else if (animals.get(i).getClass() == Dog.class) {
                countDogs++;
            }

        }
        System.out.println("Всего животных: " + animals.size() + ", из них:");
        System.out.println("Собак: " + countDogs);
        System.out.println("Кошек: " + countDogs);
    }
}
