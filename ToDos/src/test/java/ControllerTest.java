package java;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ControllerTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ControllerTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}