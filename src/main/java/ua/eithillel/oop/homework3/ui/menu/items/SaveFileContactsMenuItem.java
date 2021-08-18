package ua.eithillel.oop.homework3.ui.menu.items;

import lombok.RequiredArgsConstructor;
import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.services.ContactService;
import ua.eithillel.oop.homework3.ui.menu.ContactView;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


@RequiredArgsConstructor
public class SaveFileContactsMenuItem extends MenuItem {
    private final ContactService contactService;
    private final ContactView contactView;

    @Override
    public String getName() {
        return "Save contacts to file";
    }

    @Override
    public void run() {
        List<Contact> contacts = contactService.showAllContacts();
        try {
            contactView.createFile(contacts);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
