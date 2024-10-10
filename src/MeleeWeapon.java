public class MeleeWeapon extends Weapon {
    public MeleeWeapon(String name) {
        super(name);
    }

    @Override
    public boolean canUse() {
        return true;
    }

    @Override
    public void use() {
        System.out.println("You used the " + getName());
    }
}

