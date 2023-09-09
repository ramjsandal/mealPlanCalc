package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MacroModel implements IModel {
  private final FileUtil fileUtil;
  private final ArrayList<IRecipe> recipeLib;
  private ArrayList<IRecipe> currentRecipes;

  private SimpleRecipeSearch search;

  public MacroModel() {
    fileUtil = new SimpleFileUtil();
    recipeLib = fileUtil.load("./res/allrecipes-scraped-07-05-21.csv");
    currentRecipes = recipeLib;
    search = new SimpleRecipeSearch();
  }

  public void saveRecipeList(String path) throws IOException {
    fileUtil.save(currentRecipes, path);
  }

  public void searchRecipes() {
   currentRecipes = search.findRecipes(recipeLib);
  }

  public void setSearch(float minCals, float maxCals, float minProt,
                        float maxProt, float minCarbs, float maxCarbs, float minFats,
                        float maxFats) {
    search.setMinCalories(minCals);
    search.setMaxCalories(maxCals);
    search.setMinProtein(minProt);
    search.setMaxProtein(maxProt);
    search.setMinCarbs(minCarbs);
    search.setMaxCarbs(maxCarbs);
    search.setMinFats(minFats);
    search.setMaxFats(maxFats);
  }

  @Override
  public ArrayList<IRecipe> topX(int x) {
    ArrayList<IRecipe> ret = new ArrayList<>();

    for (int i = 0; i < x; i++) {
      ret.add(this.currentRecipes.get(i));
    }

    return ret;
  }


}
