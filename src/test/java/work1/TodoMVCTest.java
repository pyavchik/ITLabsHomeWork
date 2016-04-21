package work1;

import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.CollectionCondition.exactTexts;
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

public class TodoMVCTest extends BaseTest {
    @Test
    public void testTasksCommonFlow() {
        open("https://todomvc4tasj.herokuapp.com/");

        //create tasks 1-4
        $("#new-todo").setValue("task1").pressEnter();
        $("#new-todo").setValue("task2").pressEnter();
        $("#new-todo").setValue("task3").pressEnter();
        $("#new-todo").setValue("task4").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task2", "task3", "task4"));

        //delete task2
        $$("#todo-list>li").get(1).hover();
        $$("#todo-list>li").get(1).find(".destroy").click();
        $$("#todo-list>li").shouldHave(exactTexts("task1", "task3", "task4"));


        //mark task4 as completed
        $$("#todo-list>li").get(2).find(".toggle").click();
        $$("#todo-list>li").shouldHave(exactTexts("task1", "task3", "task4"));

        //clear completed
        $("#clear-completed").click();
        $$("#todo-list>li").shouldHave(exactTexts("task1", "task3"));

        //mark all as completed
        $("#toggle-all").click();
        $("#clear-completed").click();
        $$("#todo-list>li").shouldBe(empty);
    }

}