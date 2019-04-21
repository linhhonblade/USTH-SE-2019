import com.todo.controller.Controller;
import com.todo.controller.DataConnector;
import com.todo.model.List;
import com.todo.view.View;

import java.sql.SQLException;

public class Demo {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataConnector data = new DataConnector();
        List myList = data.readData();
        myList.showList();
        View view = new View(myList);
        Controller controller = new Controller(myList, view);
        controller.updateView(true);
        controller.setListener();
    }
}