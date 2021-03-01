package Les6;

class Dog extends Animals {

    public Dog(String name, String color, int run_dist, int swim_dist) {
        super(name, color, run_dist, swim_dist);
    }


    @Override
    protected void run(int run_dist) {
        if (run_dist <= 500) {
            super.run(run_dist);
        } else
            System.out.println(this.getColor() + " " + this.getName() + " не хочет бежать " + run_dist + " м, прикажите пробежать меньше (не больше 500 м). Собаки здесь очень ленивые");
    }

    @Override
    public void swim(int swim_dist) {
        if (swim_dist <= 10) {
            super.swim(swim_dist);
        } else
            System.out.println(this.getColor() + " " + this.getName() + " не хочет плыть " + swim_dist + " м, прикажите проплыть меньшую дистанцию (не больше 10 м)");
    }

}
