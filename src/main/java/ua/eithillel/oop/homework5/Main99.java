package ua.eithillel.oop.homework5;

import lombok.Data;
import ua.eithillel.oop.homework5.BothWayList;

import java.util.*;

@Data
public class Main99 {
    public static void main(String[] args) {

        BothWayList<String> bothWayList = new BothWayList<>();
        bothWayList.add("Messi");
        bothWayList.add("Ronaldo");
        bothWayList.add("Maradonna");
        bothWayList.add("Pele");
        bothWayList.add("Shevchenko");
        bothWayList.size();

//        for (String s : bothWayList) {
//            System.out.println(s);
//        }
        System.out.println("--------Straight List---------");

        Iterator<String> iterator = bothWayList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        bothWayList.remove("Pele");

        System.out.println("--------Reverse List---------");

        Iterator<String> reverseIterator = bothWayList.reverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }

        System.out.println("--------Some stuff---------");

        System.out.println("Size: " + bothWayList.size() + "\n"
                + "First element: " + bothWayList.getFirstElement() + "\n"
                + "Last element: " + bothWayList.getLastElement() + "\n"
                + "Element by index: " + bothWayList.get(1) + "\n"
                + "Contains: " + bothWayList.contains("Messi") + "\n"
                + "Is empty?: " + bothWayList.isEmpty() + "\n");


        System.out.println("-------------------------");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Bob");
        linkedList.add("Tom");
        linkedList.add("Ron");
        linkedList.add("Brain");
        linkedList.remove(1);

        for (String i : linkedList) {
            System.out.println(i);
        }
    }
}
