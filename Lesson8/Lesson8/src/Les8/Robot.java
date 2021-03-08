package Les8;

public class Robot implements Run {

    private String name;
    private int distToRun;
    private double heightToJump;
    private int successJumps;

    public Robot(String name, int distToRun, double heightToJump) {
        this.name = name;
        this.distToRun = distToRun;
        this.heightToJump = heightToJump;
        Lesson8.competitors.add(this);
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
        for (int j = 0; j < Lesson8.walls.size(); j++) {
            if (this.getheightToJump() >= Lesson8.walls.get(j).getheightOfWall()) {
                System.out.println("Робот " + this.getName() + " перепрыгнул через " + Lesson8.walls.get(j).getName() + " высотой " + Lesson8.walls.get(j).getheightOfWall() + " м и побежал дальше");
                successJumps++;
            } else {
                System.out.println("Робот " + this.getName() + " не смог перепрыгнуть через " + Lesson8.walls.get(j).getName() + " высотой " + Lesson8.walls.get(j).getheightOfWall() + " м.");
                break;
            }
        }
        return successJumps;
    }

    @Override
    public void run() {

        if (successJumps == Lesson8.walls.size() && this.getdistToRun() >= RunWay.staticDistOfWay) {
            System.out.println("Робот " + this.getName() + " пробежал " + RunWay.staticDistOfWay + " м и успешно финишировал");
        } else if (successJumps == Lesson8.walls.size() && this.getdistToRun() <= RunWay.staticDistOfWay) {
            System.out.println("Робот " + this.getName() + ", пробежав " + this.getdistToRun() + " м, не хватило заряда источника питания. Робот отключился.");
            System.out.println("Робот " + this.getName() + " выбыл с соревнований");
        } else if (successJumps != Lesson8.walls.size() || this.getdistToRun() <= RunWay.staticDistOfWay) {
            System.out.println("Робот " + this.getName() + " выбыл с соревнований");
        }
    }

}
