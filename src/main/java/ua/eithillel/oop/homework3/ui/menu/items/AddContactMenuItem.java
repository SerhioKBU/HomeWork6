package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.Scanner;

public class AddContactMenuItem extends MenuItem {
    Scanner scanner;
    ContactService contactService;

    public AddContactMenuItem(Scanner scanner, ContactService contactService) {
        this.scanner = scanner;
        this.contactService = contactService;
    }

    @Override
    public String getName() {
        return "Add New Contact";
    }

    @Override
    public void run() {
        System.out.println("Enter contact name: ");
        String name = scanner.nextLine();
        System.out.println("Enter contact number: ");
        String number = scanner.nextLine();
        contactService.addContact(new Contact(name, number));

    }

}
