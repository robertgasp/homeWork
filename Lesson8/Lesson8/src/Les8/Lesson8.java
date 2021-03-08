package Les8;

import java.util.ArrayList;

public class Lesson8 {

    public static ArrayList<Run> competitors = new ArrayList<>();
    public static ArrayList<Wall> walls = new ArrayList<>();

    public static void main(String[] args) {
        Human humanRodger = new Human("Роджер", 500, 1.40);
        Human humanSam = new Human("Сэм", 1000, 1.70);
        Human humanMike = new Human("Майк", 1500, 1.80);

        Cat catBoris = new Cat("Борис", 100, 1.1);
        Cat catFenya = new Cat("Феня", 110, 1.2);
        Cat catMurzik = new Cat("Мурзик", 200, 2.0);

        Robot robotRoboCop = new Robot("Робокоп", 3000, 2.5);
        Robot robotTerminatorT800 = new Robot("Терминатор Т800", 4000, 1);
        Robot robotTerminatorT1000 = new Robot("Терминатор Т1000", 5000, 3.5);

        RunWay runway = new RunWay(1000);

        Wall wall1 = new Wall("Препятствие 1", 1);
        Wall wall2 = new Wall("Препятствме 2", 1.5);
        Wall wall3 = new Wall("Препятствие 3", 1);
        Wall wall4 = new Wall("Препятствие 4", 1.2);

        //2  метода, ненужный можно закомментировать
        Wall.overcomeTheWall();

        Wall.overcomeSbd(humanRodger);
        Wall.overcomeSbd(humanSam);
        Wall.overcomeSbd(humanMike);

        Wall.overcomeSbd(catBoris);
        Wall.overcomeSbd(catFenya);
        Wall.overcomeSbd(catMurzik);
        Wall.overcomeSbd(robotRoboCop);

        Wall.overcomeSbd(robotTerminatorT800);
        Wall.overcomeSbd(robotTerminatorT1000);
    }

}