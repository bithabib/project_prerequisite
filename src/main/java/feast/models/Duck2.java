package feast.models;

public class Duck2 {

    private final Chicken3 chicken3;

    public Duck2(Chicken3 chicken3) {
        this.chicken3 = chicken3;
    }

    @Override
    public String toString() {
        return "which is stuffed inside a duck, " + chicken3.toString();
    }
}
