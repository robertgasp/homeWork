package Les6;

class Cat extends Animals {

    public Cat(String name, String color, int run_dist) {
        super(name, color, run_dist);
    }

    @Override
    protected void run(int run_dist) {
        if (run_dist <= 200) {
            super.run(run_dist);
        } else
            System.out.println(this.getColor() + " " + this.getName() + " побежал(а) бы " + run_dist + " м, но хочет преодолевать больше 200 м, попросите пробежать поменьше");
    }

    @Override
    public void swim(int swim_dist) {
        System.err.println("Коты не плавают");
    }

}
