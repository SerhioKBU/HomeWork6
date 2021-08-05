package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.Locale;
import java.util.Scanner;

public class DeleteContactMenuItem extends MenuItem {
    private Scanner scanner;

    ContactService contactService;

    public DeleteContactMenuItem(Scanner scanner, ContactService contactService) {
        this.scanner = scanner;
        this.contactService = contactService;
    }

    @Override
    public String getName() {
        return "Remove The Contact";
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        do {
            System.out.print("Enter the contact which you wanna remove: ");
            System.out.print(" ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entered value isn't a number. Try again!");
                scanner.nextLine();
                continue;
            } else {
                break;
            }
        } while (true);
        int choice = scanner.nextInt();
        scanner.nextLine();
        contactService.removeContact(choice - 1);
        System.out.println("------------------");
    }
}



