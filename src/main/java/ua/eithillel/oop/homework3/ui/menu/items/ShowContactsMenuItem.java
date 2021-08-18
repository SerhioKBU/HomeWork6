package ua.eithillel.oop.homework3.ui.menu.items;

import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.ui.menu.ContactView;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;
import ua.eithillel.oop.homework3.services.ContactService;

import java.util.List;

public class ShowContactsMenuItem extends MenuItem {
    ContactService contactService;
    ContactView contactView;

    public ShowContactsMenuItem(ContactService contactService, ContactView contactView) {
        this.contactService = contactService;
        this.contactView = contactView;
    }

    @Override
    public String getName() {
        return "Show Contacts List";
    }

    @Override
    public void run() {
        List<Contact> contacts = contactService.showAllContacts();
        contactView.writeContacts(contacts);
    }
}
