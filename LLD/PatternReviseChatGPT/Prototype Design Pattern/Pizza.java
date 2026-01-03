// Step 2: Concrete prototype
public class Pizza implements Prototype {

    private String size;
    private boolean cheese;
    private boolean pepperoni;

    public Pizza(String size, boolean cheese, boolean pepperoni) {
        this.size = size;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
    }

    @Override
    public Prototype clone() {
        return new Pizza(this.size, this.cheese, this.pepperoni);
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public void print() {
        System.out.println(size + " " + cheese + " " + pepperoni);
    }
}
