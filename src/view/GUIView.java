package view;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.IRecipe;

public class GUIView extends JFrame implements IView {

  private JLabel messages;
  private JPanel mainPanel;

  private JButton helpButton;

  private JButton searchButton;

  private JTable currentRecipes;
  private JButton nextPage;

  private JScrollPane mainScrollPane;

  public GUIView() {
    super("GUI View");

    this.setSize(500, 750);
    this.setLocation(0, 0);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    mainPanel = new JPanel();
    mainPanel.setLayout(new FlowLayout());
    mainPanel.setPreferredSize(new Dimension(1000, 700));
    mainScrollPane = new JScrollPane(mainPanel);
    this.add(mainScrollPane);

    this.helpButton = new JButton("Help");
    this.helpButton.setActionCommand("Help");
    this.mainPanel.add(this.helpButton);

    this.searchButton = new JButton("Search for meals");
    this.searchButton.setActionCommand("search");

    JPanel messagePanel = new JPanel();
    this.mainPanel.add(messagePanel);

    this.messages = new JLabel();
    messagePanel.add(messages);

    String[] headers = {"Name", "Calories", "Protein", "Carbohydrates", "Fats"};
    DefaultTableModel tableModel = new DefaultTableModel(headers, 5);
    this.currentRecipes = new JTable(tableModel);
    this.mainPanel.add(this.currentRecipes);


    this.pack();
    this.setVisible(true);

  }

  @Override
  public void outputLine(String s) {
    messages.setText(s);
  }

  @Override
  public void displayRecipes(ArrayList<IRecipe> recipes) {
    String[] headers = {"Name", "Calories", "Protein", "Carbohydrates", "Fats"};
    String[][] data = new String[recipes.size()][5];
    for (int i = 0; i < recipes.size(); i++) {
      data[i][0] = recipes.get(i).getName();
      data[i][1] = Float.toString(recipes.get(i).getCalories());
      data[i][2] = Float.toString(recipes.get(i).getProtein());
      data[i][3] = Float.toString(recipes.get(i).getCarbs());
      data[i][4] = Float.toString(recipes.get(i).getFats());
    }

    DefaultTableModel tableModel = new DefaultTableModel(data, headers);
    this.currentRecipes = new JTable(tableModel);
    this.mainPanel.add(this.currentRecipes);
    this.pack();
    this.setVisible(true);
  }
}
