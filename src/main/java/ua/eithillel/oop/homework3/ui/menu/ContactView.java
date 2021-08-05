package ua.eithillel.oop.homework3.ui.menu;

import lombok.RequiredArgsConstructor;
import ua.eithillel.oop.homework3.models.Contact;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class ContactView {
    private final Scanner scanner;
    List<Contact> contacts;

    public void writeFindNameContacts(List<Contact> contacts) {
        System.out.println("----------- FOUND NAME CONTACTS -----------");
        for (Contact contact: contacts) {
            System.out.println("Contact - " + contact.getName() +
                                " - tel.# " + contact.getPhoneNumber());
        }
        System.out.println("-------------------------------------------");
    }

    public void writeContacts(List<Contact> contacts) {
        System.out.println("----------- CONTACTS -----------");
        int number = 0;
        for (Contact item : contacts) {
            System.out.println(++ number + "." + " " + item);
       }
        System.out.println("-----------------------------");
    }
}
