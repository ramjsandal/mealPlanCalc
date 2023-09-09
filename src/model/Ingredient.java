package model;

/**
 * Represents an ingredient in a recipe.
 */
public class Ingredient {

  float measure;

  String food;

  /**
   * Constructs an {@code Ingredient}.
   * @param measure how much of the ingredient
   * @param food the food of the ingredient
   * @throws IllegalArgumentException if measure is <= 0 or food is empty
   */
  public Ingredient(float measure, String food) throws IllegalArgumentException {

    if (measure <= 0) {
      throw new IllegalArgumentException("Invalid Measure");
    }

    if (food.equals("")) {
      throw new IllegalArgumentException("Invalid food");
    }
  }

}
