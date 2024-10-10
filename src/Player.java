import java.util.ArrayList;

public class Player {
    private Room currentRoom;
    private ArrayList<Item> inventory;
    private ArrayList<Food> foodInventory;
    private int health;
    private Weapon equippedWeapon;

    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
        this.foodInventory = new ArrayList<>();
        this.health = 100;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void takeItem(Item item) {
        inventory.add(item);
    }

    public void dropItem(Item itemToDrop) {
        inventory.remove(itemToDrop);
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public ArrayList<Food> getInventory2() {
        return foodInventory;
    }

    public void takeFood(Food food) {
        foodInventory.add(food);
    }

    public void dropFood(Food food) {
        foodInventory.remove(food);
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void moveTo(Room nextRoom) {
        if (nextRoom != null) {
            currentRoom = nextRoom;
        }
    }

    public void reduceHealth(int amount) {
        health -= amount;
        System.out.println("You got damaged by " + amount + "%, your health level is now " + health + "%");
    }

    public int getHealth() {
        return health;
    }

    public void eatFood(String foodName) {
        Food foodToEat = null;
        for (Food food : foodInventory) {
            if (food.getName().equalsIgnoreCase(foodName)) ;
            foodToEat = food;
            break;
        }

        if (foodToEat != null) {
            foodInventory.remove(foodToEat);
            System.out.println("You ate a " + foodToEat.getName());
            if (foodToEat.isToxic()) {
                health -= 50;
                System.out.println("You ate something toxic, you lost 50%. Be carefull!");
            }

            System.out.println("Health level: " + health + "%");
            if (health <= 0) {
                System.out.println("You lost all health, you are DEAD...");
                System.exit(0);
            }
        } else {
            System.out.println("Your inventory do not have a " + foodName);
        }
    }

    public Item findItemInInventory(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;
    }


    // viser inventory
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("You fo not have any items");
        } else {
            System.out.println("Your inventory contains: ");
            for (Item item : inventory) {
                System.out.println(item.getName());
            }
        }

        if (foodInventory.isEmpty()) {
            System.out.println("You do not have any food");
        } else {
            System.out.println("Your food inventory contains: ");
            for (Food food : foodInventory) {
                System.out.println(food.getName());
            }
        }

        if (getEquippedWeapon() != null) {
            System.out.println("Equipped weapon: " + equippedWeapon.getName());
        } else {
            System.out.println("No weapon is equipped");
        }
    }
}
