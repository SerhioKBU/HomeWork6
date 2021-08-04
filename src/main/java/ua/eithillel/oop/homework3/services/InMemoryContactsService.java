package ua.eithillel.oop.homework3.services;

import ua.eithillel.oop.homework3.models.Contact;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class InMemoryContactsService implements ContactService {
    List<Contact> contacts = new ArrayList<>();
    private Path file = Paths.get("phonebook.txt");

    @Override
    public List<Contact> showAllContacts() {
        int number = 0;
        for (Contact item : contacts) {
            System.out.println(++ number + "." + " " + item);
        }
        return contacts;
    }

    @Override
    public List<Contact> findContactName(String name) {
        List<Contact> findNameResult = new ArrayList<>();
        for (Contact contact: contacts) {
            if(contact.getName().startsWith(name)) {
                findNameResult.add(contact);
            }
        }
        return findNameResult;
    }

    @Override
    public void removeContact(int index) {
        contacts.remove(index);
    }

    @Override
    public void addContact(Contact contact) {
        contacts.add(contact);
    }
}

