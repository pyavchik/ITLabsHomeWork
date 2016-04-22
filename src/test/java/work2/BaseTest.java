package work2;

import com.codeborne.selenide.Configuration;
import org.junit.BeforeClass;

/**
 * Created by sudo on 17.04.16.
 */
public class BaseTest {
    @BeforeClass
    public static void setUp() {
        Configuration.pageLoadStrategy = "normal";
    }
}