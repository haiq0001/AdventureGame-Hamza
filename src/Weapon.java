public abstract class Weapon extends Item {
    public Weapon(String name) {
        super(name);
    }

    public abstract boolean canUse();
    public abstract void use();
}
