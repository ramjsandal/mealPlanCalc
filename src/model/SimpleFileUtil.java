package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Implementation of the FileUtil interface.
 */
public class SimpleFileUtil implements FileUtil {

  public SimpleFileUtil() {
    // nothing;
  }

  @Override
  public ArrayList<IRecipe> load(String path) throws IllegalArgumentException {
    Scanner sc;
    ArrayList<IRecipe> recipes = new ArrayList<>();


    try {
      sc = new Scanner(new FileInputStream(path));
      sc.useDelimiter(",");
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot find file");
    }

    while(sc.hasNext()) {
      sc.useDelimiter(",");

      // name
      String name = sc.next();

      // url
      String url = sc.next();

      // category
      String category = sc.next();

      // author
      sc.next();

      // summary
      if (sc.hasNext("\".*")) {
        sc.findInLine(Pattern.compile(",\"[^\"]*\","));
      } else {
        sc.next();
      }

      // rating
      float rating;
      try {
        rating = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        rating = 0;
      }

      // rating count
      int ratingCount;
      try {
        ratingCount = Integer.parseInt(sc.next());
      } catch (NumberFormatException e) {
        ratingCount = 0;
      }

      // reviewCount
      sc.next();

      // ingredients
      sc.next();

      // directions
      sc.findInLine(Pattern.compile(",\"[^\"]*\","));

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
      float calories;
      try {
        calories = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        calories = 0;
      }

      // carbs
      float carbs;
      try {
        carbs = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        carbs = 0;
      }

      // sugars
      float sugars;
      try {
        sugars = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        sugars = 0;
      }

      // fat
      float fat;
      try {
        fat = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        fat = 0;
      }

      // saturated fat
      sc.next();

      // cholesterol
      sc.next();

      // protein
      float protein;
      try {
        protein = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        protein = 0;
      }

      // dietary fiber
      sc.next();

      // sodium
      float sodium;
      try {
        sodium = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        sodium = 0;
      }

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

      // go to next recipe
      sc.useDelimiter("\n");
      sc.next();
      /*
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
      System.out.println("Omega3 fatty acid: \n" + sc.next());

      // omega 6 fatty acid
      //sc.next();
       */

      IRecipe recipe = new Recipe(name, url, category, rating, ratingCount, calories, carbs, sugars, fat, protein, sodium);
      if (recipe.getPowerRating() > 100) {
        recipes.add(recipe);
      }
    }

    // sorts high to low
    Collections.sort(recipes, (r1, r2) -> {return (int) ((int) r2.getPowerRating() - r1.getPowerRating());});
    return recipes;
  }

  @Override
  public void save(ArrayList<IRecipe> recipes, String path) throws IllegalArgumentException, IOException {

    FileOutputStream output;
    try {
      output = new FileOutputStream(path);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Unable to create file with this path/name");
    }

      for (int i = 0; i < recipes.size(); i++) {
        byte[] toFile = recipes.get(i).toCSV().getBytes();
        output.write(toFile);
      }

  }
}
