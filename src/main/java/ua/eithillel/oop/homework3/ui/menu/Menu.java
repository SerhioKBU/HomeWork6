package ua.eithillel.oop.homework3.ui.menu;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<MenuItem> items;
    private Scanner scanner;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public Menu(Scanner scanner, List<MenuItem> items) {
        this.items = items;
        this.scanner = scanner;
    }

    private void printItem() {
        System.out.println("------ MENU ------");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s\n", + i + 1, items.get(i).getName());
        }
        System.out.printf("%d. Exit\n", items.size() + 1);
    }

    private int getChoice() {
        do {
            System.out.println("------------------");
            System.out.print("Make your choice: ");
            if (!scanner.hasNextInt()) {
                System.out.println(ANSI_RED + "Entered value isn't a number. Try again!" + ANSI_RESET);
                scanner.nextLine();
            } else {
                break;
            }
        } while (true);
        int positionMenu = scanner.nextInt();
        scanner.nextLine();
        return positionMenu - 1;
    }

    public void makeMenu() {
        while (true) {
            printItem();
            int choice = getChoice();
            if (choice < 0 || choice > items.size()) {
                System.out.println("Wrong input");
                continue;
            }

            if (choice == items.size())
                break;
            items.get(choice).run();
        }
    }
}
