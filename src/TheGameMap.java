public class TheGameMap {
    private Room currentRoom;
    private Food food;
    private Item item;
    private Weapon weapon;

    public TheGameMap() {
        createRooms();
    }

    private void createRooms() {
        Room room1 = new Room("The Forgotten Courtyard", "overgrown vines and ancient statues surround the crumbling stone walls");
        Room room2 = new Room("The Shadowy Crypt", "cold and damp, with flickering torchlight revealing skeletal remains.");
        Room room3 = new Room("The Enchanted Forest", "glowing trees and distant whispers fill the eerie, magical forest.");
        Room room4 = new Room("The Mystic Library", "dusty shelves hold ancient, glowing books in the dimly lit room.");
        Room room5 = new Room("The Sacred Grove", "a peaceful grove with a stone altar, pulsating with magical energy.");
        Room room6 = new Room("The Witch's Kitchen", "strange potions brew in cauldrons, and jars of mysterious ingredients line the shelves.");
        Room room7 = new Room("The Cursed Tower", "howling wind and cobwebs fill this towering, crumbling structure.");
        Room room8 = new Room("The Forbidden Chamber", "heavy doors seal the room, where glowing runes cover the stone walls.");
        Room room9 = new Room("The Dragon’s Lair", "scorched walls and deep claw marks hint at a lurking dragon nearby.");

        Item lamp = new Item("Lamp");

        Food apple      = new Food("Juicy Apple", false);
        Food fish       = new Food("Juicy Grilled Fish", false);
        Food toxicApple = new Food("Deadly Toxic Apple", true);
        Food nuggets    = new Food("Dragon burger With Dragon Nuggets", false);
        Food muffin     = new Food("Wizard's Enchanted Muffin", false);
        Food toxicBread = new Food("Deadly Toxic Bogwater Loaf", true);

        RangedWeapon pistol = new RangedWeapon("Pistol", 5);
        MeleeWeapon sword = new MeleeWeapon("Sword");

        Enemy monster = new Enemy("Monster, ", "A giant monster, with a giant bloody sword ", 100, new MeleeWeapon("Bloody Sword"));

        room1.setEast(room2);
        room1.setSouth(room4);
        room1.addFood(apple);
        room1.addItem(lamp);
        room1.addItem(pistol);
        room1.addItem(sword);
        room1.addEnemy(monster);

        room2.setWest(room1);
        room2.setEast(room3);
        room2.addFood(fish);
        room2.addFood(toxicApple);

        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setNorth(room1);
        room4.setSouth(room7);

        room5.setSouth(room8);
        room5.addFood(nuggets);

        room6.setNorth(room3);
        room6.setSouth(room9);
        room6.addFood(muffin);

        room7.setNorth(room4);
        room7.setEast(room8);
        room7.addFood(toxicBread);

        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setEast(room9);

        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }
}
