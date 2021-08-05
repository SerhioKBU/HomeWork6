package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.ContactView;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.Locale;
import java.util.Scanner;

public class DeleteContactMenuItem extends MenuItem {
    private Scanner scanner;
    ContactService contactService;
    ContactView contactView;

    public DeleteContactMenuItem(ContactService contactService, ContactView contactView) {
        this.contactService = contactService;
        this.contactView = contactView;
    }

    @Override
    public String getName() {
        return "Remove The Contact";
    }

    @Override
    public void run() {
        contactService.removeContact(contactView.deleteContact());
        System.out.println("------------------");
    }
}



