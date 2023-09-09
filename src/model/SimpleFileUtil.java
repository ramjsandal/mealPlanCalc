package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    int i = 0;
    int goodRecipes = 0;


    try {
      sc = new Scanner(new FileInputStream(path));
      sc.useDelimiter(",");
    } catch (IOException e) {
      throw new IllegalArgumentException("Cannot find file");
    }

    while(sc.hasNext()) {
      sc.useDelimiter(",");

      // iteration
      System.out.println(i);

      // name
      String name = sc.next();
      System.out.println("Name: \n" + name);

      // url
      String url = sc.next();
      System.out.println("URL: \n" + url);

      // category
      String category = sc.next();
      System.out.println("Category: \n" + category);

      // author
      System.out.println("Author: \n" + sc.next());

      // summary
      if (sc.hasNext("\".*")) {
        System.out.println("Has a summary in quotes: \n" + sc.findInLine(Pattern.compile(",\"[^\"]*\",")));
      } else {
        System.out.println("Has a summary with no quotes: \n" + sc.next());
      }

      // rating
      float rating;
      try {
        rating = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        rating = 0;
      }
      System.out.println("Rating: \n" + rating);

      // rating count
      int ratingCount;
      try {
        ratingCount = Integer.parseInt(sc.next());
      } catch (NumberFormatException e) {
        ratingCount = 0;
      }
      System.out.println("Rating: \n" + ratingCount);

      // reviewCount
      // was nextInt
      System.out.println("Review Count: \n" + sc.next());

      // ingredients
      System.out.println("Ingredients: \n" + sc.next());

      // directions
      System.out.println("Directions:");
      System.out.println(sc.findInLine(Pattern.compile(",\"[^\"]*\",")));

      // prep
      System.out.println("Prep:");
      System.out.println(sc.next());

      // cook
      System.out.println("Cook:");
      System.out.println(sc.next());

      // total
      System.out.println("Total: \n" + sc.next());

      // servings
      System.out.println("Servings: \n" + sc.next());

      // yield
      System.out.println("Yield: \n" + sc.next());

      // calories
      float calories;
      try {
        calories = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        calories = 0;
      }
      System.out.println("Calories: \n" + calories);

      // carbs
      float carbs;
      try {
        carbs = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        carbs = 0;
      }
      System.out.println("Carbs: \n" + carbs);

      // sugars
      float sugars;
      try {
        sugars = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        sugars = 0;
      }
      System.out.println("Sugars: \n" + sugars);

      // fat
      float fat;
      try {
        fat = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        fat = 0;
      }
      System.out.println("Fats: \n" + fat);

      // saturated fat
      System.out.println("Saturated Fats: \n" + sc.next());

      // cholesterol
      System.out.println("Cholesterol: \n" + sc.next());

      // protein
      float protein;
      try {
        protein = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        protein = 0;
      }
      System.out.println("Proteins: \n" + protein);

      // dietary fiber
      System.out.println("Dietary Fiber: \n" + sc.next());

      // sodium
      float sodium;
      try {
        sodium = Float.parseFloat(sc.next());
      } catch (NumberFormatException e) {
        sodium = 0;
      }
      System.out.println("Sodium: \n" + sodium);

      // calorie from fat
      System.out.println("Calories from fat: \n" + sc.next());

      // calcium
      System.out.println("Calcium: \n" + sc.next());

      // iron
      System.out.println("Iron: \n" + sc.next());

      // magnesium
      System.out.println("Magnesium: \n" + sc.next());

      // potassium
      System.out.println("Potassium \n" + sc.next());

      // zinc
      System.out.println("Zinc: \n" + sc.next());
      sc.useDelimiter("\n");
      System.out.println(sc.next());
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
        goodRecipes++;
      }
      i++;
    }
    System.out.println("Recipes we looked at: " + i);
    System.out.println("Good Recipes:" + goodRecipes);
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
