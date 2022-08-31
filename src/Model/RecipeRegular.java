package Model;

import java.util.ArrayList;
import java.util.Scanner;
import RecipeFactory.iRecipe;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class RecipeRegular extends Recipe implements iRecipe {
	static Scanner input = new Scanner(System.in);
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Step> steps;
	private Image image;

	/////////////////////////////////////////////////////////
//info:				contractor
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	private ArrayList<Ingredient> ObservableListTOArrayListING(ObservableList<Ingredient> ing) {
		ArrayList<Ingredient> list = new ArrayList<Ingredient>();
		for (Ingredient ingredient : ing) {
			list.add(ingredient);
		}
		return list;
	}

	private ArrayList<Step> ObservableListTOArrayListSTEP(ObservableList<Step> steps) {
		ArrayList<Step> list = new ArrayList<Step>();
		for (Step step : steps) {
			list.add(step);
		}
		return list;
	}

	public RecipeRegular(String recipeName, ObservableList<Ingredient> ings, ObservableList<Step> steps, Image image) {
		super(recipeName);
		this.ingredients = ObservableListTOArrayListING(ings);
		this.steps = ObservableListTOArrayListSTEP(steps);
		this.image = image;
	}

	public RecipeRegular() {
		super();
		this.ingredients = new ArrayList<Ingredient>();
		this.steps = new ArrayList<Step>();
		//image = new Image("/Other/recipe-default-image.png");

	}

	/////////////////////////////////////////////////////////
//info:				getters and setters
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<Step> getSteps() {
		return steps;
	}

	public void setSteps(ArrayList<Step> steps) {
		this.steps = steps;
	}

	public void addNewRecipeRegular(String name, ArrayList<Ingredient> ingredients, ArrayList<Step> steps,
			Image image) {
		setRecipeName(name);
		setIngredients(ingredients);
		setSteps(steps);
		setImage(image);
	}

/////////////////////////////////////////////////////////
//info:				factory functions
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	@Override
	public void createRecipe() {
		System.out.println("Please enter recipe reg name: ");
		setRecipeName(input.nextLine());
	}
/////////////////////////////////////////////////////////
//info:				add new step
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////

	public void addNewIngredient(String name, double amount, String ingredientWeightType) {
		ingredients.add(new Ingredient(name, amount, ingredientWeightType));
	}

/////////////////////////////////////////////////////////
//info:				add new ingredient
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public void addNewStep(int num, String step) {

		steps.add(new Step(num, step));
	}

	public String printIng() {
		String string = "";
		for (Ingredient ingredient : ingredients) {
			string = string + ingredient.toString() + "\n";
		}
		return string;
	}

	public String printStep() {
		String string = "";
		for (Step step : steps) {
			string = string + step.toString() + "\n";
		}
		return string;
	}

}
