import java.util.*;

public class FoodItem {
    private String name = " "; //Inputted by the user
    private double fat = 0; //Inputted by the user
    private double carbs = 0; //Inputted by the user
    private double protein = 0; //Inputted by the user
    //Calorie calculation constants
    private static final double CALORIES_PER_GRAM_FAT = 9.0;
    private static final double CALORIES_PER_GRAM_CARBS = 4.0;
    private static final double CALORIES_PER_GRAM_PROTEIN = 4.0;

    //The amount of calories per each macronutrient. Variables are assigned when getCalories() is run.
    private double fatCalories = 0;
    private double carbsCalories = 0;
    private double proteinCalories = 0;

    public FoodItem(String name, double fat, double carbs, double protein){
        this.name = name;
        this.fat = fat;
        this.carbs = carbs;
        this.protein = protein;
    }
    //The following methods return the amount of calories per fat, carbs, and protein.

    //Calories from fat
    private double getCaloriesFat(double fatGrams) {
        return (fatGrams*CALORIES_PER_GRAM_FAT);
    }
    //Calories from carbs
    private double getCaloriesCarbs(double carbsGrams) {
        return (carbsGrams*CALORIES_PER_GRAM_CARBS);
    }
    //Calories from protein
    private double getCaloriesProtein(double proteinGrams) {
        return (proteinGrams*CALORIES_PER_GRAM_PROTEIN);
    }

    //Calculates the total amount of calories from all the macronutrients
    public double getCalories(double numServings) {
        //Uses the calories per macronutrient constants to calculate the calories per each macronutrient
        this.fatCalories = getCaloriesFat(fat);
        this.carbsCalories = getCaloriesCarbs(carbs);
        this.proteinCalories = getCaloriesProtein(protein);

        //Adds up all the individual calories, multiplies the sum by the number of servings, then returns the value
        return numServings*(this.fatCalories+this.carbsCalories+this.proteinCalories);
    }


    public void printInfo(double numServings) {
        System.out.printf("\nNutritional information per serving of %s:\n", this.name);
        System.out.printf("Fat: %.2f g\nCarbohydrates: %.2f g\nProtein: %.2f g\n", this.fat, this.carbs, this.protein);
        System.out.printf("Total Calories for %.2f servings of %s: %.2f\n",numServings, this.name, getCalories(numServings));
        System.out.println("Dominant Macronutrient: " + getDominantMacronutrient());
    }

    private String getDominantMacronutrient() {
        String DominantMacronutrient = " ";

        //getCalories() assigns private variables for the amount of calories in fat, carbs, and protein
        this.getCalories(0);
        //First checks if fat is greater than carbs, then goes through the remaining possibilities
        if (this.fatCalories > this.carbsCalories)
            //Checks fat's relationship to protein and returns the larger one, or both of them if they're equal
            if (this.fatCalories > this.proteinCalories)
                DominantMacronutrient = "Fat";
            else if (this.fatCalories < this.proteinCalories)
                DominantMacronutrient = "Protein";
            else
                DominantMacronutrient = "Fat & Protein";
        //Checks if carbs is greater than fat
        else if (this.fatCalories < this.carbsCalories)
            //Then compares carbs to protein and returns the larger one, or both if they're equal
            if (this.carbsCalories > this.proteinCalories)
                DominantMacronutrient = "Carbohydrates";
            else if (this.carbsCalories < this.proteinCalories)
                DominantMacronutrient = "Protein";
            else
                DominantMacronutrient = "Carbohydrates & Protein";
        //If the last two branches aren't checked, carbs must be equal to fat
        else
            //Checks if protein is also equal to carbs and fat
            if ((this.fatCalories == this.carbsCalories) && (this.carbsCalories == this.proteinCalories))
                DominantMacronutrient = "Fat & Protein & Carbohydrates";
            else
                DominantMacronutrient = "Fat & Protein";

        return DominantMacronutrient;

    }
}
