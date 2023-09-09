package view;

import java.util.ArrayList;

import javax.naming.InsufficientResourcesException;

import model.IRecipe;

public interface IView {
  /**
   * Outputs the given string to the view
   * @param s string to output
   */
  public void outputLine(String s);

  public void displayRecipes(ArrayList<IRecipe> recipes);

}
