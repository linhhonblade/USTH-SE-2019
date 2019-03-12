import java.util.Date;
import java.util.Scanner;

public class Task {
    private String content;
    private Date dueDate;
    public Task(){

    }
    public boolean addContent(String newContent){
        this.content = newContent;
        return true;
    }
    public String getContent(){
        return this.content;
    }

    public boolean addContent() {
        Scanner scan = new Scanner(System.in);
        content = scan.nextLine();
        return true;
    }
    /*public boolean addDueDate(int year, int month, int date){
        dueDate = new Date(year, month, date);
        return true;

    }*/


}
