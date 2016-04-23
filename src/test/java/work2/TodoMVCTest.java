package work2;

import com.codeborne.selenide.ElementsCollection;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TodoMVCTest extends BaseTest {
    @Test
    public void testTasksCommonFlow() {

        open("https://todomvc4tasj.herokuapp.com/");

        add("1", "2", "3", "4");
        assertTasks("1", "2", "3", "4");

        delete("2");
        assertTasks("1", "3", "4");

        //complete
        toggle("4");
        clearCompleted();
        assertTasks("1", "3");

        //complete all
        toggleAll();
        clearCompleted();
        assertTasks();
    }

    private void assertTasks() {
        tasks.shouldBe(empty);
    }

    private void assertTasks(String... taskTexts) {
        tasks.shouldHave(exactTexts(taskTexts));
    }

    private void add(String... taskTexts) {
        for (String text : taskTexts) {
            $("#new-todo").setValue(text).pressEnter();
        }
    }

    private ElementsCollection tasks = $$("#todo-list li");

    private void clearCompleted() {
        $("#clear-completed").click();
    }

    private void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().find(".destroy").click();
    }

    private void toggle(String taskText) {
        tasks.find(exactText(taskText)).find(".toggle").click();
    }

    private void toggleAll() {
        $("#toggle-all").click();
    }
}