import java.util.Scanner;

public class Input {
    private  Scanner sc;

    public String getString() {
        System.out.println("Get String!");
        return sc.nextLine();
    }

    public void clear() {
        sc.nextLine();
    }

    public boolean yesNo() {
        System.out.println("Yes or No?");
        String userInput = sc.next();

        if (userInput.equalsIgnoreCase("yes") || userInput.equalsIgnoreCase("y") || userInput.equalsIgnoreCase("yup")) {
            return true;
        } else {
            return yesNo();
        }
    }

    public int getInt() {
        System.out.println("get Integer");
        return sc.nextInt();
    }

    public Input() {
        sc = new Scanner(System.in);
    }

    public int getInt(int min, int max) throws Exception {
        System.out.printf("Get whole numbers between %d and %d ", min, max);
        int userInput = Integer.parseInt(getString());
        try {
            if (userInput > max && userInput < min) {
                throw new Exception("not within range");
            }
            System.out.println("Wow! " + userInput + " is a great number!");
        } catch (NumberFormatException e) {
            System.out.println("Oh no!, not a number");
            System.out.println("Try again!");
            getInt(min, max);
        }

        return userInput;
    }

    public double getDouble() {
        System.out.println("Get number");
        return sc.nextDouble();
    }

    public double getDouble(double min, double max) throws Exception {
        System.out.printf("Get whole numbers between %f and %f\n", min, max);
        double userInput = Integer.parseInt(getString());
        try {
            if (userInput > min && userInput < max) {
                throw new Exception("Not a number broski");
            }
        } catch (NumberFormatException e) {
            System.out.println("bro not a number");
        }
        return userInput;
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return this.sc.nextLine();
    }
}