import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

import controller.CLIController;
import controller.IController;
import model.FileUtil;
import model.IModel;
import model.IRecipe;
import model.MacroModel;
import model.SimpleFileUtil;
import model.SimpleRecipeSearch;
import view.CLIView;
import view.GUIView;
import view.IView;

public class main {
  public static void main(String[] args) {
    /*
    // looks for file starting from project root
    FileUtil open = new SimpleFileUtil();
    ArrayList<IRecipe> recipes = open.load("./res/current.csv");

    // lets save a new csv that only contains quality recipes
    ArrayList<IRecipe> outRecipes = new ArrayList<>();
   for (int i = 0; i < recipes.size(); i++) {
     if (recipes.get(i).getPowerRating() > 100) {
       outRecipes.add(recipes.get(i));
     }
   }

   System.out.println("Our new list of recipes contains: " + outRecipes.size() + " recipes");

   System.out.println("Lets look for some recipes with macro constraints: ");
    SimpleRecipeSearch simpleSearch =
            new SimpleRecipeSearch("main-dish",
                    600, 1000, 40, 60, 100, 120,
                    20, 40);
    outRecipes = simpleSearch.findByRatio(outRecipes);
    System.out.println("We found " + outRecipes.size() + " recipes that fit our macro constraints");

   try {
     open.save(outRecipes, "./res/macroTest1.csv");
   } catch (IOException e) {
     throw new IllegalArgumentException("we had a mess up");
   }
     */
    IView view = new CLIView();
    //IView guiView = new GUIView();
    IModel model = new MacroModel();
    IController controller = new CLIController(model, view, new InputStreamReader(System.in));

    controller.startProgram();
  }
}
