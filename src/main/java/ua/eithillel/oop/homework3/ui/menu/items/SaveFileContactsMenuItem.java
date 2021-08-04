package ua.eithillel.oop.homework3.ui.menu.items;

import lombok.RequiredArgsConstructor;
import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.services.ContactService;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;

import java.util.List;

@RequiredArgsConstructor
public class SaveFileContactsMenuItem extends MenuItem {
    private final ContactService contactService;

    @Override
    public String getName() {
        return "Save contacts to file";
    }

    @Override
    public void run() {
//        List<Contact> contacts =  contactService.fileWriter(contact);

    }
}
