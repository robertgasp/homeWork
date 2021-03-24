package Les11;


public abstract class Fruit {

    protected String name;
    protected Float weight;
    protected String type;

    public Fruit(String name, float weight) {
        this.name = name;
        this.weight = weight;

    }

    public String getName() {
        return name;
    }

    public Float getWeight() {
        return weight;
    }


}
