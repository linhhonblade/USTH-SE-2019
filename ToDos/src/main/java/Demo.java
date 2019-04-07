public class Demo {
    public static void main(String[] args){
        List myList = new List();
        myList.add(new Task("hello"));
        myList.add(new Task("dhfwefh"));
        View view = new View(myList);
        Controller controller = new Controller(myList, view);
        controller.updateView(true);
        controller.setListener();
    }
}