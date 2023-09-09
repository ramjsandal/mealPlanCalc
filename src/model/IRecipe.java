package model;

/**
 * Interface for recipes.
 */
public interface IRecipe {

  /**
   * Gets the name of the recipe.
   * @return the name of the recipe
   */
  String getName();

  /**
   * Gets the url of the recipe.
   * @return the url of the recipe
   */
  String getURL();

  /**
   * Gets the category of the recipe.
   * @return the category of the recipe
   */
  String getCategory();

  /**
   * Gets the power rating of the recipe,
   * calculated: rating_count * (rating)^2
   * @return the power rating of the recipe
   */
  float getPowerRating();

  /**
   * Gets the calories per serving of the recipe
   * in kCal.
   * @return the calories per serving of the recipe
   */
  float getCalories();

  /**
   * Gets the carbohydrates per serving of the recipe
   * in grams.
   * @return the carbohydrates per serving of the recipe
   */
  float getCarbs();

  /**
   * Gets the sugars per serving of the recipe
   * in grams.
   * @return the sugars per serving of the recipe
   */
  float getSugars();

  /**
   * Gets the fats per serving of the recipe
   * in grams.
   * @return the fats per serving of the recipe
   */
  float getFats();

  /**
   * Gets the protein per serving of the recipe
   * in grams.
   * @return the protein per serving of the recipe
   */
  float getProtein();

  /**
   * Gets the sodium per serving of the recipe
   * in milligrams.
   * @return the sodium per serving of the recipe
   */
  float getSodium();

  /**
   * Returns the recipe info as a string in csv format
   * @return the recipe info as a string in csv format
   */
  String toCSV();


}
