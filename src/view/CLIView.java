package view;

public class CLIView implements IView {
  @Override
  public void outputLine(String s) {
    System.out.println(s);
  }
}
