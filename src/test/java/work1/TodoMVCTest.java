package work1;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static com.codeborne.selenide.CollectionCondition.exactTexts;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;

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

public class TodoMVCTest {
    @Before
    public void setUp(){
        Configuration.pageLoadStrategy = "normal";
    }

    @Test
    public void testCommonLifeCycleTodoMVC() {
        open("https://todomvc4tasj.herokuapp.com/");

        //create task1
        $("#new-todo").setValue("task1").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1"));

        //create task2
        $("#new-todo").setValue("task2").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task2"));

        //create task3
        $("#new-todo").setValue("task3").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task2", "task3"));

        //create task4
        $("#new-todo").setValue("task4").pressEnter();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task2", "task3", "task4"));

        //delete task2
        $$("#todo-list li").get(1).hover();
        $$("#todo-list li button").get(1).click();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task3", "task4"));


        //mark task4 as completed
        $$("#todo-list li input").get(2).click();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task3", "task4"));

        //clear completed
        $("#clear-completed").click();
        $$("#todo-list li").shouldHave(exactTexts("task1", "task4"));

        //mark all as completed
        $("#toggle-all").click();
        $("#clear-completed").click();
        $$("#todo-list li").shouldHaveSize(0);
    }

}
