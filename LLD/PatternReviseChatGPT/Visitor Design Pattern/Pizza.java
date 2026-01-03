class Pizza implements Element {
    int price = 300;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this); // 🔥 key line
    }
}
