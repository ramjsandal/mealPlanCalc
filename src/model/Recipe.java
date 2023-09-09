package model;

/**
 * Represents a recipe.
 */
public class Recipe implements IRecipe {

  private final String name;

  private final String url;

  private final String category;

  private final float rating;

  private final int ratingCount;

  private final int powerRating;

  private final float calories;

  private final float carbs;

  private final float sugars;

  private final float fats;

  private final float protein;

  private final float sodium;


  /**
   * Constructs an {@code Recipe} object
   * @param name name of the recipe
   * @param url url of the recipe
   * @param category type of recipe
   * @param rating rating out of 5 stars
   * @param ratingCount number of ratings
   * @param calories
   * @param carbs
   * @param sugars
   * @param fats
   * @param protein
   * @param sodium
   * @throws IllegalArgumentException
   */
  public Recipe(String name, String url, String category,
                float rating, int ratingCount,
                float calories, float carbs, float sugars,
                float fats, float protein, float sodium) throws IllegalArgumentException {

    if (name.equals("") || url.equals("")) {
      throw new IllegalArgumentException("Invalid name or URL");
    }

    this.name = name;
    this.url = url;
    this.category = category;
    this.rating = rating;
    this.ratingCount = ratingCount;
    this.powerRating = (int) (rating * rating * ratingCount);
    this.calories = calories;
    this.carbs = carbs;
    this.sugars = sugars;
    this.fats = fats;
    this.protein = protein;
    this.sodium = sodium;

  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getURL() {
    return this.url;
  }

  @Override
  public String getCategory() {
    return this.category;
  }

  @Override
  public float getPowerRating() {
    return this.powerRating;
  }

  @Override
  public float getCalories() {
    return this.calories;
  }

  @Override
  public float getCarbs() {
    return this.carbs;
  }

  @Override
  public float getSugars() {
    return this.sugars;
  }

  @Override
  public float getFats() {
    return this.fats;
  }

  @Override
  public float getProtein() {
    return this.protein;
  }

  @Override
  public float getSodium() {
    return this.sodium;
  }
}
