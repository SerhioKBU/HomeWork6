package ua.eithillel.oop.homework3.services;

import ua.eithillel.oop.homework3.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class InMemoryContactsService implements ContactService {
    List<Contact> contacts = new ArrayList<>();

    @Override
    public List<Contact> showAllContacts() {
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

