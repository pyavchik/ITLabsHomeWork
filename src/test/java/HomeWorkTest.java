import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by sudo on 16.04.16.
 * 1 create task1
 * 2 create task2
 * 3 create task3
 * 4 create task4
 * 5 delete task2
 * 6 mark task4 as completed
 * 7 clear completed
 * 8 mark all as completed
 * 9 clear completed
 */
public class HomeWorkTest {
    @Test
    public void testCreateTask1() {
        timeout = 10000;
        open("https://todomvc4tasj.herokuapp.com/");

        //create task1
        $("#new-todo").setValue("task1").pressEnter().shouldHave(text(""));
        $$(".view>label").get(0).shouldHave(text("task1"));

        //create task2
        $("#new-todo").setValue("task2").pressEnter().shouldHave(text(""));
        $$(".view>label").get(1).shouldHave(text("task2"));

        //create task3
        $("#new-todo").setValue("task3").pressEnter().shouldHave(text(""));
        $$(".view>label").get(2).shouldHave(text("task3"));

        //create task4
        $("#new-todo").setValue("task4").pressEnter().shouldHave(text(""));
        $$(".view>label").get(3).shouldHave(text("task4"));

        //delete task2
        $$(".view>label").get(1).click();
        $$(".destroy").get(1).click();

        //mark task4 as completed
        $$(".toggle").get(2).click();

        //clear completed
        $("#clear-completed").click();

        //mark all as completed
        $$(".toggle").get(0).click();
        $$(".toggle").get(1).click();

        $("#clear-completed").click();
    }

}
