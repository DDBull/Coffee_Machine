package machine;
import java.util.*;

public class CoffeeMachine {

    private static void printStateOfCoffeMachine(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d of water\n", water);
        System.out.printf("%d of milk\n", milk);
        System.out.printf("%d of coffee beans\n", beans);
        System.out.printf("%d of disposable cups\n", cups);
        System.out.printf("%d of money\n\n", money);
    }

    private static int isCoffeeAvailable(int water, int milk, int beans, int cups, int coffeeType) {

        int waterRequired = 0;
        int milkRequired = 0;
        int beansRequired = 0;
        int cupsRequired = 1;
        int moneyEarned = 0;

        switch (coffeeType) {
            case 1:
                waterRequired = 250;
                milkRequired = 0;
                beansRequired = 16;
                moneyEarned = 4;
                break;
            case 2:
                waterRequired = 350;
                milkRequired = 75;
                beansRequired = 20;
                moneyEarned = 7;
                break;
            case 3:
                waterRequired = 200;
                milkRequired = 100;
                beansRequired = 12;
                moneyEarned = 6;
                break;
            default:
                break;
        }

        if (water < waterRequired) {
            System.out.println("Sorry, not enough water!\n");
            return 0;
        }
        if (milk < milkRequired) {
            System.out.println("Sorry, not enough milk!\n");
            return 0;
        }
        if (beans < beansRequired) {
            System.out.println("Sorry, not enough coffee beans!\n");
            return 0;
        }
        if (cups < cupsRequired) {
            System.out.println("Sorry, not enough cups!\n");
            return 0;
        }

        System.out.println("I have enough resources, making you a coffee!\n");
        return moneyEarned;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        String exitSign = "exit";
        String coffeeChoice;

        System.out.print("Write action (buy, fill, take, remaining, exit): ");
        String userAction = scanner.nextLine();
        System.out.println();

        while (!userAction.equals(exitSign)) {
            switch (userAction) {
                case "buy":
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    coffeeChoice = scanner.next();
                    int moneyEarned;

                    switch (coffeeChoice) {
                        case "back":
                            System.out.println();
                            break;
                        case "1":
                            moneyEarned = isCoffeeAvailable(water, milk, beans, cups, 1);

                            if (moneyEarned > 0) {
                                water -= 250;
                                beans -= 16;
                                cups--;
                                money += moneyEarned;
                            }

                            break;
                        case "2":
                            moneyEarned = isCoffeeAvailable(water, milk, beans, cups, 2);

                            if (moneyEarned > 0) {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups--;
                                money += moneyEarned;
                            }
                            break;
                        case "3":
                            moneyEarned = isCoffeeAvailable(water, milk, beans, cups, 3);

                            if (moneyEarned > 0) {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups--;
                                money += moneyEarned;
                            }
                            break;
                        default:
                            break;
                    }

                    break;
                case "fill":
                    System.out.print("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();

                    System.out.print("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();

                    System.out.print("Write how many grams of coffee beans do you want to add: ");
                    beans += scanner.nextInt();

                    System.out.print("Write how many disposable cups of coffee do you want to add: ");
                    cups += scanner.nextInt();

                    System.out.println();
                    break;
                case "take":
                    System.out.println("I gave you $" + money + "\n");
                    money = 0;
                    break;
                case "remaining":
                    printStateOfCoffeMachine(water, milk, beans, cups, money);
                    break;
                default:
                    System.out.println("ERROR!");
                    System.exit(0);
                    break;
            }

            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            userAction = scanner.next();
            System.out.println();
        }
    }
}
