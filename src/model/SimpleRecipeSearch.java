package model;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

public class SimpleRecipeSearch {
  private final String category;
  private final float minCalories;
  private final float maxCalories;

  private final float minProtein;
  private final float maxProtein;
  private final float minCarbs;
  private final float maxCarbs;
  private final float minFats;
  private final float maxFats;

  public SimpleRecipeSearch(String category, float minCals, float maxCals, float minProt,
                            float maxProt, float minCarbs, float maxCarbs, float minFats,
                            float maxFats) {
    this.category = category;
    this.minCalories = minCals;
    this.maxCalories = maxCals;
    this.minProtein = minProt;
    this.maxProtein = maxProt;
    this.minCarbs = minCarbs;
    this.maxCarbs = maxCarbs;
    this.minFats = minFats;
    this.maxFats = maxFats;
  }

  public ArrayList<IRecipe> findRecipes(ArrayList<IRecipe> recipes) {
    ArrayList<IRecipe> out = new ArrayList<>();
    for (int i = 0; i < recipes.size(); i++) {
      IRecipe current = recipes.get(i);
      if (inRange(current.getCalories(), minCalories, maxCalories)
              && inRange(current.getCarbs(), minCarbs, maxCarbs)
              && inRange(current.getFats(), minFats, maxFats)
              && inRange(current.getProtein(), minProtein, maxProtein)) {
        out.add(current);
      }
    }
    return out;
  }

  public ArrayList<IRecipe> findByRatio(ArrayList<IRecipe> recipes) {
    float minCalRatio;
    float maxCalRatio;

    float minCarbRatio;
    float maxCarbRatio;

    float minProtRatio;
    float maxProtRatio;

    float minFatRatio;
    float maxFatRatio;

    ArrayList<IRecipe> out = new ArrayList<>();
    for (int i = 0; i < recipes.size(); i++) {
      IRecipe current = recipes.get(i);
      minCalRatio = current.getCalories() / minCalories;
      minCarbRatio = current.getCarbs() / minCarbs;
      minFatRatio = current.getFats() / minFats;
      minProtRatio = current.getProtein() / minProtein;

      maxCalRatio = current.getCalories() / maxCalories;
      maxCarbRatio = current.getCarbs() / maxCarbs;
      maxFatRatio = current.getFats() / maxFats;
      maxProtRatio = current.getProtein() / maxProtein;


    }
    return out;
  }

  private boolean inRange(float num, float min, float max) {
    return (num >= min && num <= max);
  }

  private Tuple<Float, Float> rangeOverlap(Tuple<Float, Float> range1, Tuple<Float, Float> range2) {
    if (inRange(range2.first, range1.first, range1.second)
            || inRange(range2.second, range1.first, range1.second)) {
      Tuple ret = new Tuple(Math.max(range1.first, range2.first), Math.min(range1.second, range2.second));
      return ret;
    }
    return null;
  }

  private Tuple<Float, Float> findRange(Tuple<Float, Float> cals, Tuple<Float, Float> carbs,
                                        Tuple<Float, Float> fats, Tuple<Float, Float> protein) {
  Tuple<Float, Float> ret = new Tuple<>(0f,0f);
  return ret;
  }
}
