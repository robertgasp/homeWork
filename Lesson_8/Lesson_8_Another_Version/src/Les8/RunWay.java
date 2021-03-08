package Les8;

public class RunWay {

    private int distOfWay;
    public static int staticDistOfWay;

    protected RunWay(int distOfWay) {
        this.distOfWay = distOfWay;
        staticDistOfWay = this.getdistOfWay();
    }

    public int getdistOfWay() {
        return distOfWay;
    }

}
