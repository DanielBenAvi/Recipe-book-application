package Model;

import java.util.Scanner;
import RecipeFactory.iRecipe;


public class RecipeLink extends Recipe implements iRecipe {
	static Scanner input = new Scanner(System.in);
	private String link;

/////////////////////////////////////////////////////////
//info:				contractor
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public RecipeLink(String recipeName, String link) {
		super(recipeName);
		this.link = link;
	}

	public RecipeLink() {
		super();
		this.link = "";
	}

/////////////////////////////////////////////////////////
//info:				getters and setters
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
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
		System.out.println("Please enter recipe link name: ");
		setRecipeName(input.nextLine());
	}
	
	public void addRecipeLink(String name, String link) {
		setRecipeName(name);
		setLink(link);
	}

	@Override
	public String toString() {
		return   link  ;
	}
	
	
	



	

}
