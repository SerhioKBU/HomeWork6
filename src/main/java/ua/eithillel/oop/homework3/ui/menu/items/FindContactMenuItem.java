package ua.eithillel.oop.homework3.ui.menu.items;

import lombok.RequiredArgsConstructor;
import ua.eithillel.oop.homework3.models.Contact;
import ua.eithillel.oop.homework3.services.ContactService;
import ua.eithillel.oop.homework3.ui.menu.ContactView;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class FindContactMenuItem extends MenuItem {
    private final ContactService contactService;
    private final ContactView contactView;
    private final Scanner scanner;

    @Override
    public String getName() {
        return "Find contact name";
    }

    @Override
    public void run() {
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        List<Contact> contacts = contactService.findContactName(name);
        contactView.writeFindNameContacts(contacts);
    }
}
