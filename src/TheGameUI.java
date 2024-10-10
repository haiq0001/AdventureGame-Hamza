import java.util.Scanner;

public class TheGameUI {
    private Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine().toLowerCase().trim();
    }

    public void printWelcomeMessage() {
        System.out.println("⭐⭐⭐  Welcome to the Adventure Game  ⭐⭐⭐");
        System.out.println("Type 'help' to see the instructions");
    }

    public void printHelp() {
        System.out.println("The instructions:");
        System.out.println("North/N: Move north");
        System.out.println("South/S: Move south");
        System.out.println("East/E: Move east");
        System.out.println("West/W: Move west");
        System.out.println("Look: Look around");
        System.out.println("Inventory: Open inventory");
        System.out.println("Take: Take item");
        System.out.println("Drop: Drop item");
        System.out.println("Take food: Take food");
        System.out.println("Equip: Equip weapon");
        System.out.println("Attack: Attack enemy");
        System.out.println("Eat: Eat the food");
        System.out.println("Exit: Exit the game");
    }

    public void printRoomDescription(Room room) {
        System.out.print("Your location is: " + room.getName());
        System.out.println(", " + room.getDescription());

        if (!room.getItems().isEmpty()) {
            System.out.print("Items in this room: ");
            for (Item item : room.getItems()) {
                System.out.println(item.getName());
            }
        }

        if (!room.getFood().isEmpty()) {
            System.out.print("Food in this room: ");
            for (Food food : room.getFood()) {
                System.out.println(food.getName());
            }
        }

        if (!room.getEnemies().isEmpty()) {
            System.out.print("Enemy in this room: ");
            for (Enemy enemy : room.getEnemies()) {
                System.out.println(enemy.getName() + enemy.getDescription() + " Health level: " + enemy.getHealth());
            }
        }
    }

    public void printExitMessage () {
        System.out.println("Thanks for playing!");
    }

    public void printInvalidCommand () {
        System.out.println("❌ERROR❌");
    }

    public void printWrongWayError () {
        System.out.println("⛔ERROR WRONG WAY⛔");
    }

    public void printMessage (String message){
        System.out.println(message);
    }
}
