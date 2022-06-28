import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        }
    }

    private static void displayContacts() {
        Path filepath = Paths.get("data", "contacts.txt");
        List<String> lines;
        List<Contact> contacts = new ArrayList<>();
        try {
            lines = Files.readAllLines(filepath);
            for (String line : lines) {
                System.out.printf("%s%n", line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void addContact (){

    }
}

