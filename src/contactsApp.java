import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.awt.geom.Path2D.contains;

public class contactsApp {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. View contacts.\n" +
                "2. Add a new contact.\n" +
                "3. Search a contact by name.\n" +
                "4. Delete an existing contact.\n" +
                "5. Exit.\n" +
                "Enter an option (1, 2, 3, 4 or 5):");
        int userInput = sc.nextInt();
        if (userInput == 1) {
            displayContacts();
        } else if (userInput == 2) {
            addContact();
        } else if (userInput == 3) {
            searchContact("");
        }else if (userInput == 4) {
            deleteContact("");
        }else if (userInput == 5) {
            System.out.println("Thank you for using our App!!");
        }
    }

    private static void displayContacts() {
        Path filepath = Paths.get("data", "contacts.txt");
        List<String> lines;
        try {
            lines = Files.readAllLines(filepath);
            System.out.printf("Name  | Phone number%n ---------------%n");
            for (String line : lines) {
                System.out.printf("%s%n", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addContact() {
        Path filepath = Paths.get("data", "contacts.txt");
        Input in = new Input();
        List<String> lines;
        List<Contact> contacts = new ArrayList<>();
        try {
            lines = Files.readAllLines(filepath);
            System.out.printf("Name  | Phone number%n ---------------%n");
            for (String line : lines) {
                String[] splitStr = line.split("|");
                contacts.add(new Contact(splitStr[0], splitStr[1]));
            }
            String firstName = in.getString("Whats the Contact's Full Name?");
            String phoneNumber = in.getString("Whats the Contact's Number?");
            String lineForFile = String.format("%s  | %s", firstName, phoneNumber);
            Files.write(filepath, Arrays.asList(lineForFile), StandardOpenOption.APPEND);
            lines.add(lineForFile);
            contacts.add(new Contact(firstName, phoneNumber));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void searchContact(String search) {
        Path filepath = Paths.get("data", "contacts.txt");
        Input in = new Input();
        String firstNamesearch = in.getString("who's number are you looking for");
        List<String> lines;
//        List<Contact> contacts = new ArrayList<>();
        try {
            lines = Files.readAllLines(filepath);
            System.out.printf("Name  | Phone number%n ---------------%n");
        for (String line : lines) {
            if (line.toLowerCase().contains(firstNamesearch)) {
                System.out.println(line);
            }
        }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

        private static StringBuilder deleteContact(String search) {
            Path filepath = Paths.get("data", "contacts.txt");
            Input in = new Input();
            String Namedelete = in.getString("who's contact do you want to delete");
            List<String> lines;
            try {
                lines = Files.readAllLines(filepath);
                System.out.printf("Name  | Phone number%n ---------------%n");
                StringBuilder newline = new StringBuilder();
                for (String line : lines) {
                    if (line.toLowerCase().contains(Namedelete)) {
                        continue;
                    }
                    newline.append(line).append("\n");
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new StringBuilder();
        }
}
