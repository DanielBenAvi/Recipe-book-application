package RecipeFactory;

import Model.Recipe;
import Model.RecipeLink;
import Model.RecipeRegular;

public class RecipeFactory {
	public Recipe getRecipe(String type) {
		if (type == null) {
			return null;
		}
		if (type.equalsIgnoreCase("Regular")) {
			return new RecipeRegular();
		}
		
		if (type.equalsIgnoreCase("Link")) {
			return new RecipeLink();
		}		
		return null;
		
	}
}
