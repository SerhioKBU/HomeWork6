package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.List;
import java.util.Scanner;

public class ShowContactsMenuItem extends MenuItem {
    List<Contact> contacts;
    Contact contact;
    Scanner scanner;
    ContactService contactService;

    public ShowContactsMenuItem(ContactService contactService) {
        this.contactService = contactService;
    }

    @Override
    public String getName() {
        return "Show Contacts List";
    }

    @Override
    public void run() {
        System.out.println("--------------");
        contactService.showAllContacts();
        System.out.println("--------------");
    }
}
