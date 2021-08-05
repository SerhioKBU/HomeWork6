package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.services.ContactService;


public class ShowContactsMenuItem extends MenuItem {
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
