package ua.eithillel.oop.homework3;

import ua.eithillel.oop.homework3.services.ContactService;
import ua.eithillel.oop.homework3.services.InMemoryContactsService;
import ua.eithillel.oop.homework3.ui.menu.ContactView;
import ua.eithillel.oop.homework3.ui.menu.items.*;
import ua.eithillel.oop.homework3.ui.menu.Menu;
import ua.eithillel.oop.homework3.ui.menu.MenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ContactService contactService = new InMemoryContactsService();
        ContactView contactView = new ContactView(scanner);
        List<MenuItem> menuItemList = Arrays.asList(
                new AddContactMenuItem(scanner, contactService),
                new ShowContactsMenuItem(contactService, contactView),
                new DeleteContactMenuItem(contactService, contactView),
                new FindContactMenuItem(contactService, contactView, scanner),
                new SaveFileContactsMenuItem(contactService)
        );
        Menu menu = new Menu(scanner, menuItemList);
        menu.makeMenu();

    }
}
