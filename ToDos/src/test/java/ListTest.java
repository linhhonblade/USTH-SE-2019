import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ListTest {
    private List testedList = new List();

    @Before
    public void init() {
        testedList.add(new Task("hello world"));
        testedList.add(new Task("follow me"));
        testedList.add(new Task("buy fruits"));
    }

    @Test
    public void testSize() {
        assertEquals("Checking size of list", 3, testedList.size());
    }
    @Test
    public void testShowList() throws Exception{
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        testedList.showList();
        String expectedOutput = "List Info:\nhello world\nfollow me\nbuy fruits\n";
        assertEquals(expectedOutput,outContent.toString());
    }

    @Test
    public void testAdd() {
        testedList.add(new Task("keep calm"));
        assertEquals("Adding 1 more task to list", 4, testedList.size());
    }

    @Test
    public void testRemove() {
        testedList.remove(2);
        assertEquals("Remove 1 task from list", 2, testedList.size());
    }

    @Test
    public void testClear() {
        testedList.clear();
        assertEquals("Remove all tasks from list", 0, testedList.size());
    }
}