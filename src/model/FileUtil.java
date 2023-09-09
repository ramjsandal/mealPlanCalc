package model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Utility class for loading files
 */
public interface FileUtil {

  /**
   * Loads the file at the given path as an array of recipes.
   * @param path filepath of the file (.csv)
   * @return list of recipes
   * @throws IllegalArgumentException if the file cannot be loaded
   */
  public ArrayList<IRecipe> load(String path) throws IllegalArgumentException;

  /**
   * Saves the recipe as a file at the given path.
   * @param recipes the recipes to save
   * @param path the location to save the recipe to
   * @throws IllegalArgumentException if the file cannot be saved
   */
  public void save(ArrayList<IRecipe> recipes, String path) throws IllegalArgumentException, IOException;



}
