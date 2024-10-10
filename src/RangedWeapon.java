public class RangedWeapon extends Weapon {
    private int ammonition;

    public RangedWeapon(String name, int ammonition) {
        super(name);
        this.ammonition = ammonition;
    }

    @Override
    public boolean canUse() {
        return ammonition > 0;
    }

    @Override
    public void use() {
        if (ammonition > 0) {
            ammonition--;
            System.out.println("You fired the " + getName() + ", ammonition left: " + ammonition);
        } else {
            System.out.println("You are out of ammotion");
        }
    }
}

