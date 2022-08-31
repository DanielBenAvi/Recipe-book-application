package Model;

public class Ingredient {
	private String ingredientName;
	private double ingredientAmount;
	private String ingredientWeightType;

/////////////////////////////////////////////////////////
//info:				contractor
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public Ingredient(String ingredientName, double ingredientAmount, String ingredientWeightType) {
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientWeightType = ingredientWeightType;
	}

/////////////////////////////////////////////////////////
//info:				getters and setters	
//Input:  
//Output:	
//by:
//last updated:
/////////////////////////////////////////////////////////
	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public double getIngredientAmount() {
		return ingredientAmount;
	}

	public void setIngredientAmount(double ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}

	public String getIngredientWeightType() {
		return ingredientWeightType;
	}

	public void setIngredientWeightType(String ingredientWeightType) {
		this.ingredientWeightType = ingredientWeightType;
	}

	@Override
	public String toString() {
		return "" + ingredientName + "   " + ingredientAmount + " " + ingredientWeightType;
	}

}
