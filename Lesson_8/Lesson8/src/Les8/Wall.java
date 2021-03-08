package Les8;


public class Wall {

    private double heightOfWall;
    private String name;


    protected Wall(String name, double heightOfWall) {
        this.name = name;
        this.heightOfWall = heightOfWall;
        Lesson8.walls.add(this);
    }

    public String getName() {
        return name;
    }


    public double getheightOfWall() {
        return heightOfWall;
    }

    //Здесь 2 варианта оформления программы:1-без входных параметров,чтобы разом всех участников прогнать, второй-с указанием объекта

    public static void overcomeTheWall() {
        for (int i = 0; i < Lesson8.competitors.size(); i++) {
            Lesson8.competitors.get(i).jump();
            Lesson8.competitors.get(i).run();
            System.out.println();
        }
    }

    public static void overcomeSbd(Run obj) {
        obj.jump();
        obj.run();
    }
}
