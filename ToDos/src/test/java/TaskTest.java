import com.todo.model.Task;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class TaskTest {
    Task myTask = new Task("hello");
    @Before
    public void init(){
        myTask.setState("done");
    }
    @Test
    public void testgetContent(){
        assertEquals("hello",myTask.getContent());
    }

    @Test
    public void testprintContent() throws Exception{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        myTask.printContent();
        String expectedOutput = "hello\n";
        assertEquals(expectedOutput,outContent.toString());
    }
    @Test
    public void testgetState(){
        assertEquals("done",myTask.getState());
    }

}