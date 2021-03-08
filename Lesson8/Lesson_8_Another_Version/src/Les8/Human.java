package Les8;

public class Human implements Run {

    private String name;
    private int distToRun;
    private double heightToJump;
    private int successJumps;


    protected Human(String name, int distToRun, double heightToJump) {
        this.name = name;
        this.distToRun = distToRun;
        this.heightToJump = heightToJump;
        Lesson_8.competitors.add(this);
    }

    public String getName() {
        return name;
    }

    public int getdistToRun() {
        return distToRun;
    }

    public double getheightToJump() {
        return heightToJump;
    }


    @Override
    public int jump() {
        successJumps = 0;
        for (int j = 0; j < Lesson_8.walls.size(); j++) {
            if (this.getheightToJump() >= Lesson_8.walls.get(j).getheightOfWall()) {
                System.out.println("Человек " + this.getName() + " перепрыгнул через " + Lesson_8.walls.get(j).getName() + " высотой " + Lesson_8.walls.get(j).getheightOfWall() + " м и побежал дальше");
                successJumps++;
            } else {
                System.out.println("Человек " + this.getName() + " не смог перепрыгнуть через " + Lesson_8.walls.get(j).getName() + " высотой " + Lesson_8.walls.get(j).getheightOfWall() + " м.");
                break;
            }
        }
        return successJumps;
    }

    @Override
    public void run() {

        if (successJumps == Lesson_8.walls.size() && this.getdistToRun() >= RunWay.staticDistOfWay) {
            System.out.println("Человек " + this.getName() + " пробежал " + RunWay.staticDistOfWay + " м и успешно финишировал");
        } else if (successJumps == Lesson_8.walls.size() && this.getdistToRun() <= RunWay.staticDistOfWay) {
            System.out.println("Человек " + this.getName() + ", пробежав " + this.getdistToRun() + " м, выдохся и решил, что на сегодня хватит.");
        } else if (successJumps != Lesson_8.walls.size() || this.getdistToRun() <= RunWay.staticDistOfWay) {
            System.out.println("Человек " + this.getName() + " выбыл с соревнований");
        }
    }
}
