package work2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.junit.BeforeClass;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by sudo on 17.04.16.
 */
public class BaseTest {
    @BeforeClass
    public static void setUp() {
        Configuration.pageLoadStrategy = "normal";
    }
    public void assertTasksAre(String... taskText) {
        tasks.shouldHave(exactTexts(taskText));
    }

    public void add(String... taskText) {
        for (String text : taskText) {
            $("#new-todo").setValue(text).pressEnter();
        }
    }

    public ElementsCollection tasks = $$("#todo-list li");

    public void clearCompleted() {
        $("#clear-completed").click();
    }

    public void delete(String taskText) {
        tasks.find(exactText(taskText)).hover().find(".destroy").click();
    }

    public void toggleAll() {
        $("#toggle-all").click();
    }

    public void toggle(String text) {
        tasks.find(exactText(text)).find(".toggle").click();
    }
}
