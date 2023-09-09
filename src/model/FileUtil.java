package model;

/**
 * Utility class for loading files
 */
public interface FileUtil {

  /**
   * Loads the file at the given path as an array of recipes.
   * @param path filepath of the file
   * @return list of recipes
   * @throws IllegalArgumentException if the file cannot be loaded
   */
  public IRecipe[] load(String path) throws IllegalArgumentException;

  /**
   * Saves the recipe as a file at the given path.
   * @param recipe the recipe to save
   * @param path the location to save the recipe to
   * @throws IllegalArgumentException if the file cannot be saved
   */
  public void save(IRecipe[] recipe, String path) throws IllegalArgumentException;



}
