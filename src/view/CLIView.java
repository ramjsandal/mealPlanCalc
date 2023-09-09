package view;

import java.util.ArrayList;

import model.IRecipe;

public class CLIView implements IView {
  @Override
  public void outputLine(String s) {
    System.out.println(s);
  }

  @Override
  public void displayRecipes(ArrayList<IRecipe> recipes) {
    System.out.println("These are the top " + recipes.size() + " recipes under your current search criteria");
    for (int i = 0; i < recipes.size(); i++) {
      System.out.println(recipes.get(i).toString());
    }
  }
}
