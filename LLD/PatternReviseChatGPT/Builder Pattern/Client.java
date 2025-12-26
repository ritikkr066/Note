public class Client {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder()
        .size("Large")
        .addCheese()
        .addPepperoni()
        .build();

        pizza.printDetails();
    }
}
