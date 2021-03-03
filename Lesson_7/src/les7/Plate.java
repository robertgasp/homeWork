package les7;

public class Plate {

    private int skolkoEdy;
    private int emkost_plate;

    protected Plate(int skolkoEdy, int emkost_plate) {


        if (this.skolkoEdy <= this.emkost_plate) {
            this.skolkoEdy = skolkoEdy;
            this.emkost_plate = emkost_plate;
        } else System.err.println("Введите наполненность тарелки меньше ее емкости");
    }

    public void setSkolkoEdy(int skolkoEdy) {
        this.skolkoEdy = skolkoEdy;
    }

    public int getSkolkoEdy() {
        return skolkoEdy;
    }

    public int getEmkost_plate() {
        return emkost_plate;
    }

    public void giveFood(int food) {
        if ((this.getSkolkoEdy() + food) <= this.getEmkost_plate()) {
            this.setSkolkoEdy(this.getSkolkoEdy() + food);
            System.out.println("Добавлено " + food + " г корма, всего корма в тарелке " + getSkolkoEdy() + " г");
        } else
            System.out.println(food + " г - это слишком много. Тарелка будет переполнена, в данный момент она заполнена на " + getSkolkoEdy() + " г, емкость тарелки " + getEmkost_plate() + " г");
    }
}