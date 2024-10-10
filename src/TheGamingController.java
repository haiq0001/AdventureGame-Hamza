// aka Adventure
public class TheGamingController {
    private Player player;
    private TheGameMap map;
    private TheGameUI ui;
    private String command;

    public TheGamingController() {
        map = new TheGameMap();
        player = new Player(map.getCurrentRoom());
        ui = new TheGameUI();
    }

    public void play() {
        ui.printWelcomeMessage();

        while (true) {
            String input = ui.getUserInput();
            switch (input) {
                case "north":
                case "n":
                    move(player.getCurrentRoom().getNorth(), "north");
                    break;

                case "south":
                case "s":
                    move(player.getCurrentRoom().getSouth(), "south");
                    break;

                case "east":
                case "e":
                    move(player.getCurrentRoom().getEast(), "east");
                    break;

                case "west":
                case "w":
                    move(player.getCurrentRoom().getWest(), "west");
                    break;

                case "look":
                    ui.printRoomDescription(player.getCurrentRoom());
                    break;

                case "help":
                    ui.printHelp();
                    break;

                case "inventory":
                case "inv":
                    player.showInventory();
                    break;

                case "take":
                    handleTakeCommmand();
                    break;

                case "equip":
                    handleEquipCommand();
                    break;

                case "attack":
                    handleAttackCommand();
                    break;

                case "take food":
                    handleTakeFoodCommand();
                    break;

                case "eat":
                    handleEatCommand();
                    break;

                case "drop":
                    handleDropCommand();
                    break;

                case "exit":
                    ui.printExitMessage();
                    return;

                default:
                    ui.printInvalidCommand();
                    break;
            }
        }
    }

    private void move(Room nextRoom, String direction) {
        if (nextRoom != null) {
            player.moveTo(nextRoom);
            ui.printRoomDescription(player.getCurrentRoom());
        } else {
            ui.printWrongWayError();
        }
    }

    private void handleTakeCommmand() {
        ui.printMessage("What item do you want?");
        String itemName = ui.getUserInput();
        Item item = player.getCurrentRoom().findItem(itemName);
        if (item != null) {
            player.takeItem(item);
            player.getCurrentRoom().removeItem(item);
            ui.printMessage("You picked up a: " + item.getName());
        } else {
            ui.printMessage("There is no " + itemName + " here.");
        }
    }

    private void handleDropCommand() {
        ui.printMessage("What item do you want to drop?");
        String itemName = ui.getUserInput();
        Item itemToDrop = null;

        for (Item item : player.getInventory()) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                itemToDrop = item;
                break;
            }
        }
        if (itemToDrop != null) {
            player.dropItem(itemToDrop);
            player.getCurrentRoom().addItem(itemToDrop);
            ui.printMessage("You dropped a: " + itemToDrop.getName());
        } else {
            ui.printMessage("You do not have a " + itemName + " in your inventory.");
        }
    }

    private void handleTakeFoodCommand() {
        ui.printMessage("What do you want to eat?");
        String foodName = ui.getUserInput();
        Food food = player.getCurrentRoom().findFood(foodName);
        if (food != null) {
            player.takeFood(food);
            player.getCurrentRoom().removeFood(food);
            ui.printMessage("You have picked up a " + food.getName());
        } else {
            ui.printMessage("There is no " + foodName);
        }
    }

    private void handleEatCommand() {
        ui.printMessage("What do you want to eat?");
        String foodName = ui.getUserInput();
        player.eatFood(foodName);
    }

    private void handleEquipCommand() {
        ui.printMessage("What weapon do you want to use?");
        String weaponName = ui.getUserInput();
        Item item = player.findItemInInventory(weaponName);
        if (item instanceof Weapon) {
            player.equipWeapon((Weapon) item);
            ui.printMessage("You just equipped the " + weaponName);
        } else {
            ui.printMessage("Your weapon inventory does not have " + weaponName);
        }
    }

    private void handleAttackCommand() {
        System.out.println("What do you want to attack?");
        String enemyName = ui.getUserInput();
        Enemy enemy = player.getCurrentRoom().findEnemy(enemyName);

        Weapon weapon = player.getEquippedWeapon();
        if ( weapon == null) {
            System.out.println("You have not equipped any weapon");
            return;
        }

        if (enemy == null) {
            System.out.println("That enenym is not in the room");
            if (weapon.canUse()) {
                weapon.use();
            } else {
                System.out.println("You can not use this weapon");
            }
            return;
        }

        if (weapon.canUse()) {
            System.out.println("You just attacked " + enemy.getName() + " with your " + weapon.getName());
            enemy.hit(25);
            weapon.use();
        } else {
            System.out.println("You can not use this weapon");
            return;
        }

        if (enemy.isDefeated()) {
            player.getCurrentRoom().removeEnemy(enemy);
            player.getCurrentRoom().addItem(enemy.getWeapon());
        } else {
            System.out.println(enemy.getName() + " is attacking you! Be carefull");
            enemy.attack(player);
        }

        if (player.getHealth() <= 0) {
            System.out.println("You got killed");
            System.exit(0);
        }
    }
}
