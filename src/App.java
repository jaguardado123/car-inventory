import java.util.*;

public class App {
    public static void main(String[] args) {
        // Start my code here.

        // Software Development Life Cycle (SDLC)
        //  Process used to build your application.
        //  - Waterfall Approach
        //  - Big Bang Approach

        // We're going to build a Car Inventory App.
        // 1st Step: Requirement Analysis.
        //   - So what information do we need?
        //   - Car has make, model, year.
        //   - Going to be storing multiple cars.
        //   - Give user oppoortunity of how many cars to input.

        // 2nd Step: Design.
        //  - How do we want our app to look like?
        //  - Our app is going to be on the terminal.
        
        // 3rd Step: Implementation
        //  - I shoudl create a CarInventory class.
        //  - I want to store multiple cars (make, model, year).

        // CarInventory inventory = new CarInventory();
        // System.out.println("Welcome to Car Inventory App!");
        // // System.out.print("Enter a make model year: ");

        // String make, model, decision = " ";
        // int year;
        // Scanner input = new Scanner(System.in);

        // // Let's put this in a loop.
        // do {
        //     try {
        //         // Getting my user input.
        //         System.out.print("Enter a make model year: ");
        //         make = input.next();
        //         model = input.next();
        //         year = input.nextInt();

        //         // Insert into my inventory.
        //         inventory.insert(make, model, year);

        //         // Ask if they want to input a new car.
        //         System.out.print("Enter a new car (y/n): ");
        //         decision = input.next();
        //     }
        //     catch(Exception e) {
        //         // input.nextLine();
        //         System.out.println("Input mismatch!");
        //         System.out.println(e.toString());
        //     }
        // } while(decision.charAt(0) == 'y');

        // // User selected n (any letter other than y)
        // System.out.println("Car Inventory: ");
        // inventory.printCars();

        // Creating our CarInventoryGUI object.
        CarInventoryGUI car_app = new CarInventoryGUI();
    }
}

class Car {
    public String model;
    public String make;
    public int year;

    public Car(String p_make, String p_model, int p_year) {
        make = p_make;
        model = p_model;
        year = p_year;
    }
}

// CarInventory class is going to inherit the CarDatabase class.
class CarInventory extends CarDatabase {
    // Attributes.
    private Car[] cars = new Car[25];
    // private String[] models = new String[25];
    // private String[] makes = new String[25];
    // private int[] years = new int[25];
    private int current = 0;
    private int size = 25;

    private void resize() {
        // Created a new set of larger arrays.
        size = size * 2;
        Car[] temp_cars = new Car[size];
        // String[] temp_models = new String[size];
        // String[] temp_makes = new String[size];
        // int[] temp_years = new int[size];

        // Copied information from original arrays.
        for(int i = 0; i < current; i++) {
            temp_cars[i] = cars[i];
            // temp_models[i] = models[i];
            // temp_makes[i] = makes[i];
            // temp_years[i] = years[i];
        }

        // Assign my temporary arrays to replace my original arrays.
        // models = temp_models;
        // makes = temp_makes;
        // years = temp_years;
        cars = temp_cars;
    }

    // Methods to modify my Attributes
    // Since I'm working w/ parallel arrays, I'm going to make
    //  a single setter method.
    public void insert(String p_make, String p_model, int p_year) {
        // if (current >= size) {
        //     resize();
        // }
        // // Assigning my parameters into my arrays.
        // cars[current] = new Car(p_make, p_model, p_year);
        // // makes[current] = p_make;
        // // models[current] = p_model;
        // // years[current] = p_year;
        // current++;
        insertTable(p_make, p_model, p_year);
    }

    public void printCars() {
        cars = selectTable();

        for(int i = 0; i < cars.length; i++) {
            System.out.println((i + 1) + ". " + cars[i].make + ", " + cars[i].model + 
            ", " + cars[i].year);
        }
    }
}
