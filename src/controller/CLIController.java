package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import model.FileUtil;
import model.IRecipe;
import model.Recipe;
import model.SimpleFileUtil;
import model.SimpleRecipeSearch;
import view.IView;

public class CLIController implements IController {
  private final IView view;
  private final Readable input;

  public CLIController(IView view, Readable input) {
    this.view = view;
    this.input = input;
  }
  @Override
  public void startProgram() {
    boolean quit = false;
    Scanner sc = new Scanner(System.in);
    String input;
    float temp;
    FileUtil fileLoader = new SimpleFileUtil();
    ArrayList<IRecipe> allRecipes = fileLoader.load("./res/current.csv");
    ArrayList<IRecipe> currentRecipes = new ArrayList<>();

    view.outputLine("Welcome to the MacroCalc CLI program");
    view.outputLine("Type 'help' for a list of commands");

    while (!quit) {
      input = sc.next();
      switch (input.toLowerCase()) {
        case "help":
          view.outputLine("Here are a list of commands:");
          view.outputLine("help -- Prints this menu");
          view.outputLine("find-meals output-file mincal maxcal minprot maxprot mincarbs maxcarbs minfats maxfats " +
                  "-- Searches the list of recipes for one that meets these macro requirements");
          break;
        case "find-meals":
          String outfile = sc.next();
          float minCal = Float.parseFloat(sc.next());
          float maxCal = Float.parseFloat(sc.next());
          float minProt = Float.parseFloat(sc.next());
          float maxProt = Float.parseFloat(sc.next());
          float minCarb = Float.parseFloat(sc.next());
          float maxCarb = Float.parseFloat(sc.next());
          float minFats = Float.parseFloat(sc.next());
          float maxFats = Float.parseFloat(sc.next());

          SimpleRecipeSearch srs = new SimpleRecipeSearch(" ", minCal, maxCal,
                  minProt, maxProt, minCarb, maxCarb, minFats, maxFats);
          view.outputLine("Searching for recipes that match your criteria, please wait a moment");
          currentRecipes = srs.findRecipes(allRecipes);
          try {
            fileLoader.save(currentRecipes, outfile);
            view.outputLine("Search finished, all recipes found saved to: " + outfile);
          } catch (IOException e ) {
            view.outputLine("Could not save recipes, please try another file path");
          }
          break;
        case "quit":
          quit = true;
      }
    }
  }
}
