import java.util.Scanner;

public class NutritionTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Uses a while loop to keep asking the user for input until they've entered a positive integer
        int numberFoodItems = 0;
        while (numberFoodItems <= 0) {
            //Asks the user for the amount of food items to analyze, then stores the value
            System.out.print("How many food items would you like to input?: ");
            numberFoodItems = scanner.nextInt();
            if (numberFoodItems <= 0)
                System.out.printf("\n\"%d\" is not a positive integer! Enter a positive integer.\n\n",numberFoodItems);
        }

        //Creates a FoodItem array corresponding to the inputted value
        FoodItem[] allFoodItems = new FoodItem[numberFoodItems];

        //Defines totalCalories here so that the amount of calories for each food item can be added to this variable
        double totalCalories = 0;
        for (int i=0; i < numberFoodItems; i++) {
            //Asks the user for the name of the food. Formats the prompt so that it specifies the item's placement.
            System.out.printf("\nEnter the name of food item #%d: ", (i+1));
            String foodName = scanner.next();

            //Asks the user for the amount of fat. Continues to ask for input until a positive number is entered
            System.out.printf("Enter the amount of fat in %s (grams): ", foodName);
            double fatAmount = positiveNumberInput();

            //Asks the user for the amount of carbs. Continues to ask for input until a positive number is entered
            System.out.printf("Enter the amount of carbs in %s (grams): ", foodName);
            double carbsAmount = positiveNumberInput();

            //Asks the user for the amount of protein. Continues to ask for input until a positive number is entered
            System.out.printf("Enter the amount of protein in %s (grams): ", foodName);
            double proteinAmount = positiveNumberInput();

            //Asks the user for the amount of servings. Continues to ask for input until a positive number is entered
            System.out.print("Enter the number of servings: ");
            double servingsAmount = positiveNumberInput();


            //Creates a FoodItem object with the provided information
            FoodItem newestFood = new FoodItem(foodName, fatAmount, carbsAmount, proteinAmount);

            //Gets the amount of calories, then adds it to the total amount of calories for all foods
            double caloriesAmount = newestFood.getCalories(servingsAmount);
            totalCalories += caloriesAmount;

            //Displays the nutritional information about the food item
            newestFood.printInfo(servingsAmount);
        }
        //Outputs total calories and a "Thank you" message
        System.out.printf("\nTotal combined calories for all food items: %.2f", totalCalories);
        System.out.println("\nThank you for using the Nutrition Information System!");

    }
    //An input function that only allows the user to input positive numbers.
    public static double positiveNumberInput() {
        Scanner scanner = new Scanner(System.in);

        //Takes the user's input and checks if it is a valid value
        double userInput = scanner.nextDouble();
        while (userInput < 0) {
            //If the input is less than zero, the user is asked to input another number
            System.out.printf("\n\"%.2f\" is not a positive number! \n\nEnter a positive number: ",userInput);
            userInput = scanner.nextDouble();
        }
        return userInput;
    }

}