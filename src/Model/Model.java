package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import RecipeFactory.RecipeFactory;
import javafx.scene.image.Image;

public class Model {
	ArrayList<Recipe> recipes;

	public Model() {
		hardCode();
		
	}



	public void hardCode() {

		recipes = new ArrayList<Recipe>();

		recipes.add(new RecipeFactory().getRecipe("regular"));
		recipes.get(0).setRecipeName("pizza");
		recipes.get(0).setFavorite(true);
		((RecipeRegular) recipes.get(0)).addNewIngredient("cheese", 1, "kg");
		((RecipeRegular) recipes.get(0)).addNewIngredient("tomato", 500, "gr");
		((RecipeRegular) recipes.get(0)).addNewStep(1, "open oven");
		((RecipeRegular) recipes.get(0)).addNewStep(2, "close oven");

		recipes.add(new RecipeFactory().getRecipe("regular"));
		recipes.get(1).setRecipeName("burger");
		((RecipeRegular) recipes.get(1)).addNewIngredient("meet", 1, "gk");
		((RecipeRegular) recipes.get(1)).addNewIngredient("bread", 200, "gr");
		((RecipeRegular) recipes.get(1)).addNewStep(1, "open oven");
		((RecipeRegular) recipes.get(1)).addNewStep(2, "close oven");

		recipes.add(new RecipeFactory().getRecipe("regular"));
		recipes.get(2).setRecipeName("sushi");
		((RecipeRegular) recipes.get(2)).addNewIngredient("rise", 2, "kg");
		((RecipeRegular) recipes.get(2)).addNewIngredient("fish", 250, "gr");
		((RecipeRegular) recipes.get(2)).addNewStep(1, "open oven");
		((RecipeRegular) recipes.get(2)).addNewStep(2, "close oven");

		recipes.add(new RecipeFactory().getRecipe("link"));
		recipes.get(3).setRecipeName("Crispy Pan-Seared Fish");
		((RecipeLink) recipes.get(3))
				.setLink("www.seriouseats.com/the-food-lab-the-easiest-foolproof-crispy-pan-seared-fish-filets");
		recipes.get(3).setFavorite(true);
		recipes.add(new RecipeFactory().getRecipe("link"));
		recipes.get(4).setRecipeName("Homemade French Fries");

		((RecipeLink) recipes.get(4)).setLink("www.seriouseats.com/perfect-french-fries-recipe");

	}

	public Recipe findRercipeByName(String name) {

		for (Recipe recipe : recipes) {
			if (recipe.getRecipeName() == name) {
				return recipe;
			}
		}
		return null;

	}

	public ArrayList<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(ArrayList<Recipe> recipes) {
		this.recipes = recipes;
	}

	public void createNewRegularRecipe(String name, ArrayList<Ingredient> ingredients, ArrayList<Step> steps,
			Image image, String[] ingTypes) throws FileNotFoundException {
		recipes.add(new RecipeFactory().getRecipe("regular"));
		((RecipeRegular) recipes.get(recipes.size() - 1)).addNewRecipeRegular(name, ingredients, steps, image);

	}

	public void createNewLinkRecipe(String name, String link) {
		recipes.add(new RecipeFactory().getRecipe("link"));
		((RecipeLink) recipes.get(recipes.size() - 1)).addRecipeLink(name, link);

	}

	public void deleteRecipe(Recipe recipe) {

		recipes.remove(recipe);

	}




	public void updateRecipeRegular(String name, RecipeRegular recipe) {
		for (Recipe r : recipes) {
			if (r.getRecipeName().equals(name)) {
				r.setRecipeName(recipe.getRecipeName());
				((RecipeRegular) r).setIngredients(recipe.getIngredients());
				((RecipeRegular) r).setSteps(recipe.getSteps());

			}
		}

	}

}
