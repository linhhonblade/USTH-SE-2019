import java.util.ArrayList;
public class List{
    private ArrayList<Task> taskList;
    public boolean addTask(Task newTask){
        if(newTask==null){
            System.out.println("Wrong input format, should be an instance of class Task");
            return false;
        }
        else{
            taskList.add(newTask);
        }
    }
}