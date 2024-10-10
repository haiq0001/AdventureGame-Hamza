public class Food {
    private String name;
    private boolean toxic;

    public Food(String name, boolean toxic) {
        this.name = name;
        this.toxic = toxic;
    }

    public String getName() {
        return name;
    }

    public boolean isToxic() {
        return toxic;
    }

    public void add(Food food) {
    }

    public void remove(Food food) {
    }
}