package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.Scanner;

public class DeleteContactMenuItem extends MenuItem {
    private Scanner scanner;

    ContactService contactService;
    //List<Contact> contacts;

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
        System.out.println("Enter the contact which you wanna remove: ");
//        if(!scanner.hasNextInt()) {
//            System.out.println("Введённое значение не является числом");
//            return;
//        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        contactService.removeContact(choice - 1);
        System.out.println("------------------");
    }


}

//    @Override
//    public void run() {
//        System.out.print("Enter New Contact (Name + Tel Number): ");
//        String newContact = scanner.nextLine();
//        contacts.remove();
//    }

