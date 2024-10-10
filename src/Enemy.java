public class Enemy {
    private String name;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String name, String description, int health, Weapon weapon) {
        this.name = name;
        this.description = description;
        this.health = health;
        this.weapon = weapon;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getHealth() {
        return health;
    }

    public void hit(int damage) {
        health -= damage;
        if (health <=0) {
            System.out.println(name + " is dead and drops the " + weapon.getName());
        }
    }

    public void attack(Player player) {
        if (weapon != null && weapon.canUse()) {
            System.out.println(name + " is attacing you with a " + weapon.getName());
            weapon.use();
            player.reduceHealth(50);
        }
    }

    public boolean isDefeated() {
        return health <= 0;
    }
}
