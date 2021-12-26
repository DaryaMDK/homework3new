import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Main {

    @BeforeEach
    void setup(){
        Configuration.browserSize = "1920x1080";
        open("https://github.com/selenide/selenide");
    }

    @Test
    void checkWiki(){
        $x("//*[@id=\"wiki-tab\"]").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $("[data-filterable-for=\"wiki-pages-filter\"]").shouldHave(text("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
