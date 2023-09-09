package model;

import java.awt.font.NumericShaper;
import java.util.ArrayList;

public class SimpleRecipeSearch {
  private String category;

  private float minCalories;
  private float maxCalories;

  private float minProtein;
  private float maxProtein;
  private float minCarbs;
  private float maxCarbs;
  private float minFats;
  private float maxFats;

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

  public SimpleRecipeSearch() {
    this("", 0, 100000, 0, 100000, 0, 100000, 0, 100000);
  }

  public ArrayList<IRecipe> findRecipes(ArrayList<IRecipe> recipes) {
    ArrayList<IRecipe> out = new ArrayList<>();
    System.out.println("Looking at recipes");
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

    Tuple<Float, Float> currentRange;

    ArrayList<IRecipe> out = new ArrayList<>();
    for (int i = 0; i < recipes.size(); i++) {
      IRecipe current = recipes.get(i);
      minCalRatio = minCalories / current.getCalories();
      minCarbRatio = minCarbs / current.getCarbs();
      minFatRatio = minFats / current.getFats();
      minProtRatio = minProtein / current.getProtein();

      maxCalRatio = maxCalories / current.getCalories();
      maxCarbRatio = maxCarbs / current.getCarbs();
      maxFatRatio = maxFats / current.getFats();
      maxProtRatio = maxProtein / current.getProtein();
      Tuple<Float, Float> cals = new Tuple<>(minCalRatio, maxCalRatio);
      Tuple<Float, Float> carb = new Tuple<>(minCarbRatio, maxCarbRatio);
      Tuple<Float, Float> fat = new Tuple<>(minFatRatio, maxFatRatio);
      Tuple<Float, Float> prot = new Tuple<>(minProtRatio, maxProtRatio);

      currentRange = findRange(cals, carb, fat, prot);
      if (currentRange == null) {
        continue;
      } else {
        System.out.println(findBestServing(currentRange));
        out.add(current);
      }


    }
    return out;
  }

  private boolean inRange(float num, float min, float max) {
    return (num >= min && num <= max);
  }

  private Tuple<Float, Float> rangeOverlap(Tuple<Float, Float> range1, Tuple<Float, Float> range2)
  throws IllegalArgumentException {
    if (inRange(range2.first, range1.first, range1.second)
            || inRange(range2.second, range1.first, range1.second)) {
      Tuple ret = new Tuple(Math.max(range1.first, range2.first), Math.min(range1.second, range2.second));
      return ret;
    }
    throw new IllegalArgumentException("These two tuples do not overlap");
  }

  private Tuple<Float, Float> findRange(Tuple<Float, Float> cals, Tuple<Float, Float> carbs,
                                        Tuple<Float, Float> fats, Tuple<Float, Float> protein) {
  Tuple<Float, Float> ret = new Tuple<>(Float.MIN_VALUE, Float.MAX_VALUE);
  try {
    ret = rangeOverlap(ret, cals);
    ret = rangeOverlap(ret, carbs);
    ret = rangeOverlap(ret, fats);
    ret = rangeOverlap(ret, protein);
  } catch (IllegalArgumentException e) {
    return null;
  }

  return ret;
  }

  private float findBestServing(Tuple<Float, Float> range) {
    // if we have an int in our acceptable range, use that, otherwise use float in the middle
    int intVersion = (int) ((range.first + range.second) / 2);
    if (inRange(intVersion, range.first, range.second)) {
      return intVersion;
    }

    return roundToNearestQuarter((range.first + range.second) / 2);
  }

  private float roundToNearestQuarter(float f) {

    float ret = Math.round(f * 4);
    ret = ret / 4;
    return ret;
  }

  public float getMinCalories() {
    return minCalories;
  }

  public void setMinCalories(float minCalories) {
    this.minCalories = minCalories;
  }

  public float getMaxCalories() {
    return maxCalories;
  }

  public void setMaxCalories(float maxCalories) {
    this.maxCalories = maxCalories;
  }

  public float getMinProtein() {
    return minProtein;
  }

  public void setMinProtein(float minProtein) {
    this.minProtein = minProtein;
  }

  public float getMaxProtein() {
    return maxProtein;
  }

  public void setMaxProtein(float maxProtein) {
    this.maxProtein = maxProtein;
  }

  public float getMinCarbs() {
    return minCarbs;
  }

  public void setMinCarbs(float minCarbs) {
    this.minCarbs = minCarbs;
  }

  public float getMaxCarbs() {
    return maxCarbs;
  }

  public void setMaxCarbs(float maxCarbs) {
    this.maxCarbs = maxCarbs;
  }

  public float getMinFats() {
    return minFats;
  }

  public void setMinFats(float minFats) {
    this.minFats = minFats;
  }

  public float getMaxFats() {
    return maxFats;
  }

  public void setMaxFats(float maxFats) {
    this.maxFats = maxFats;
  }

}
