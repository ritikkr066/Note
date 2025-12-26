class Pizza {
    private String size;
    private boolean cheese;
    private boolean pepperoni;

    private Pizza(Builder builder) {
        this.size = builder.size;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
    }

    public void printDetails() {
        System.out.println(
            "Size: " + size +
            ", Cheese: " + cheese +
            ", Pepperoni: " + pepperoni
        );
    }

    public static class Builder {
        private String size;
        private boolean cheese;
        private boolean pepperoni;

        public Builder size(String size) {
            this.size = size;
            return this;
        }

        public Builder addCheese() {
            this.cheese = true;
            return this;
        }

        public Builder addPepperoni() {
            this.pepperoni = true;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}
