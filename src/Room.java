import java.util.ArrayList;

public class Room {
    private String name;
    private String description;
    private Room north, south, east, west;
    private ArrayList<Item> items;
    private ArrayList<Food> food;
    private ArrayList<Enemy> enemies;


    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.items = new ArrayList<>();
        this.food = new ArrayList<>();
        this.enemies = new ArrayList<>();
    }

    // tilføj item til rummet
    public void addItem(Item item) {
        items.add(item);
    }

    // sletter item fra rummet
    public void removeItem(Item item) {
        items.remove(item);
    }

    // viser items i rummet
    public ArrayList<Item> getItems() {
        return items;
    }

    public void addFood(Food food) {
        this.food.add(food);
    }

    public void removeFood(Food food) {
        this.food.remove(food);
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public void addEnemy(Enemy enemy) {
        this.enemies.add(enemy);
    }

    public void removeEnemy(Enemy enemy) {
        this.enemies.remove(enemy);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public Enemy findEnemy(String name) {
        for ( Enemy enemy : enemies) {
            if (enemy.getName().equalsIgnoreCase(name)) {
                return enemy;
            }
        }
        return null;
    }

    public Food findFood(String name) {
        for (Food food : food) {
            if (food.getName().equalsIgnoreCase(name)) {
                return food;
            }
        }
        return null;
    }

    public Item findItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }

        return null;

    }

    public String getName() {
        return name;
    }

    public String getDescription () {
        return description;
    }

    public Room getNorth () {
        return north;
    }

    public void setNorth (Room north){
        this.north = north;
    }

    public Room getSouth () {
        return south;
    }

    public void setSouth (Room south){
        this.south = south;
    }

    public Room getEast () {
        return east;
    }

    public void setEast (Room east){
        this.east = east;
    }

    public Room getWest () {
        return west;
    }

    public void setWest (Room west){
        this.west = west;
    }
}
