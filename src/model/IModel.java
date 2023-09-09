package model;

import java.io.IOException;
import java.util.ArrayList;

public interface IModel {
  /**
   * Saves the current list of recipes to a file, written as a csv
   * @param path path to save file to
   * @throws IOException if the file cannot be saved
   */
  public void saveRecipeList(String path) throws IOException;

  /**
   * Searches the current list of recipes by the search parameters
   */
  public void searchRecipes();

  /**
   * Updates the search parameters
   * @param minCals min calories in the recipe
   * @param maxCals max calories in the recipe
   * @param minProt min protein in the recipe
   * @param maxProt max protein in the recipe
   * @param minCarbs min carbs in the recipe
   * @param maxCarbs max carbs in the recipe
   * @param minFats min fats in the recipe
   * @param maxFats max fats in the recipe
   */
  public void setSearch(float minCals, float maxCals, float minProt,
                        float maxProt, float minCarbs, float maxCarbs, float minFats,
                        float maxFats);

  /**
   * Returns the top rated recipes in the current search
   * @param x the number of recipes to return
   * @return the top x rated recipes in the current search
   */
  public ArrayList<IRecipe> topX(int x);
}
