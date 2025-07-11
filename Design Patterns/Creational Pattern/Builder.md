
class Burger {
    private String bun;
    private boolean cheese;
    private boolean lettuce;
    private boolean tomato;
    private boolean mayo;

    private Burger(Builder builder) {
        this.bun = builder.bun;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.tomato = builder.tomato;
        this.mayo = builder.mayo;
    }

    public void showBurger() {
        System.out.println("Burger with: " + bun + ", " +
            (cheese ? "cheese, " : "") +
            (lettuce ? "lettuce, " : "") +
            (tomato ? "tomato, " : "") +
            (mayo ? "mayo" : ""));
    }

    //  Builder Inner Class
    public static class Builder {
        private String bun;
        private boolean cheese;
        private boolean lettuce;
        private boolean tomato;
        private boolean mayo;

        public Builder(String bun) {
            this.bun = bun;
        }

        public Builder cheese(boolean val) {
            this.cheese = val;
            return this;
        }

        public Builder lettuce(boolean val) {
            this.lettuce = val;
            return this;
        }

        public Builder tomato(boolean val) {
            this.tomato = val;
            return this;
        }

        public Builder mayo(boolean val) {
            this.mayo = val;
            return this;
        }

        public Burger build() {
            return new Burger(this);
        }
    }}





![image](https://github.com/user-attachments/assets/4e8f0ba3-7beb-41ed-874e-e688a841b313)
