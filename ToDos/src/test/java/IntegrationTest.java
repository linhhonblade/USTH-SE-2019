import com.todo.controller.Controller;
import com.todo.controller.DataConnector;
import com.todo.model.List;
import com.todo.view.View;
import org.assertj.swing.edt.GuiActionRunnable;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static org.assertj.swing.finder.WindowFinder.findFrame;

public class IntegrationTest {
    private FrameFixture window;
    @Before
    public void setUp(){
        DataConnector data = new DataConnector();
        final List myList = data.readData();
        View frame = GuiActionRunnable.execute(() -> new View(myList));
        Controller controller = new Controller(myList, frame);
        frame = controller.setListener();
        window = new FrameFixture(frame);
        window.show();
    }

    @Test
    public void
}
