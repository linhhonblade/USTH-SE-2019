import java.util.ArrayList;

public class List{
    private ArrayList<Task> taskList;

    public List(){
        taskList = new ArrayList<Task>();
    }
    public void addTask(Task newTask){
        if(newTask==null){
            System.out.println("Wrong input format, should be an instance of class Task");
        }
        else{
            taskList.add(newTask);
            System.out.println("New task added");
        }
    }
}