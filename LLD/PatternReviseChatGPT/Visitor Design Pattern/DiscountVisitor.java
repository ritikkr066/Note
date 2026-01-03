class DiscountVisitor implements Visitor {
    @Override
    public void visit(Pizza pizza) {
        System.out.println("Discount on Pizza");
    }

    @Override
    public void visit(Burger burger) {
        System.out.println("Discount on Burger");
    }
}
