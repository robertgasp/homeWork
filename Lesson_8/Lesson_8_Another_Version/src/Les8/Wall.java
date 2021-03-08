package Les8;

import java.util.ArrayList;

public class Wall {

    private double heightOfWall;
    private String name;


    protected Wall(String name, double heightOfWall) {
        this.name = name;
        this.heightOfWall = heightOfWall;
        Lesson_8.walls.add(this);
    }

    public String getName() {
        return name;
    }

    public double getheightOfWall() {
        return heightOfWall;
    }
}
