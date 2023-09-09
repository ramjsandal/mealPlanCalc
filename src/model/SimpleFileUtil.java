package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implementation of the FileUtil interface.
 */
public class SimpleFileUtil implements FileUtil {

  @Override
  public IRecipe[] load(String path) throws IllegalArgumentException {
    Scanner sc;


    try {
      sc = new Scanner(new FileInputStream(path));
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot find file");
    }

    while(sc.hasNext()) {

      String name = sc.next();
      String url = sc.next();
      String category = sc.next();
      // author
      sc.next(",");
      // summary
      sc.next("\"");
      sc.next("\"");
      float rating = sc.nextFloat();
      int ratingCount = sc.nextInt();
      // reviewCount
      sc.nextInt();
      // ingredients
      sc.next();
      // directions
      sc.next("\"");
      sc.next("\"");
      // prep
      sc.next();
      // cook
      sc.next();
      // total
      sc.next();
      // servings
      sc.next();
      // yield
      sc.next();
      // calories
      float calories = sc.nextFloat();
      // carbs
      float carbs = sc.nextFloat();
      // sugars
      float sugars = sc.nextFloat();
      // fat
      float fat = sc.nextFloat();
      // saturated fat
      sc.next();
      // cholesterol
      sc.next();
      // protein
      float protein = sc.nextFloat();
      // dietary fiber
      sc.next();
      // sodium
      float sodium = sc.nextFloat();
      // calorie from fat
      sc.next();
      // calcium
      sc.next();
      // iron
      sc.next();
      // magnesium
      sc.next();
      // potassium
      sc.next();
      // zinc
      sc.next();
      // phosphorous
      sc.next();
      // vitamin a
      sc.next();
      // niacin equivalents
      sc.next();
      // vitamin b6
      sc.next();
      // vitamin c
      sc.next();
      // folate
      sc.next();
      // thiamin
      sc.next();
      // riboflavin
      sc.next();
      // vitamin e
      sc.next();
      // vitamin k
      sc.next();
      // biotin
      sc.next();
      // vitamin b12
      sc.next();
      // mono fat
      sc.next();
      // poly fat
      sc.next();
      // trans fatty acid
      sc.next();
      // omega 3 fatty acid
      sc.next();
      // omega 6 fatty acid
      sc.next();

      IRecipe recipe = new Recipe(name, url, category, rating, ratingCount, calories, carbs, sugars, fat, protein, sodium);
    }

    return new IRecipe[0];
  }

  @Override
  public void save(IRecipe[] recipe, String path) throws IllegalArgumentException {

  }
}
