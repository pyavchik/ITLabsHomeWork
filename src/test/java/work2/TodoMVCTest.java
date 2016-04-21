package work2;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Selenide.open;

public class TodoMVCTest extends BaseTest {
    @Test
    public void testTasksCommonFlow() {

        open("https://todomvc4tasj.herokuapp.com/");

        add("1", "2", "3", "4");
        assertTasksAre("1", "2", "3", "4");

        delete("2");
        assertTasksAre("1", "3", "4");

        toggle("4");
        clearCompleted();
        assertTasksAre("1", "3");

        toggleAll();
        clearCompleted();
        tasks.shouldBe(empty);
    }
}