package ua.eithillel.oop.homework3.models;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@RequiredArgsConstructor
public class Contact {
    private final String name;
    private final String phoneNumber;

//    public Contact(String name, String phoneNumber) {
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
    public String toString() {
        return "Contact: " + name + " | " + "Tel.# " + phoneNumber + " |";
    }
}
