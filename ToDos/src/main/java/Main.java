import javax.swing.SwingUtilities;

public class Main{
  public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
      public void run()
      {
        ListGUI1 newListGUI = new ListGUI1("Todo List");
      }
    });
  }
}