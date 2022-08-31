package Model;

import RecipeFactory.iRecipe;


public abstract class Recipe implements iRecipe{
	protected String recipeName;
	protected boolean isFavorite;



	/////////////////////////////////////////////////////////
//info:				contractor
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public Recipe(String recipeName) {
		this.recipeName = recipeName;
		isFavorite = false;
	}

	public Recipe() {
		this.recipeName = "";
		isFavorite = false;
	}
/////////////////////////////////////////////////////////
//info:				getters and setters
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	

public boolean isFavorite() {
		return isFavorite;
	}

	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}

	@Override
	public String toString() {
		return "Recipe\n" + recipeName + ",\n isFavorite?" + isFavorite;
	}
	
	
	

}