import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTestForAllureListener {

    @Test
    public void searchIssueTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");
        $(".search-input").click();
        $("#query-builder-test").setValue("qaness/demo").pressEnter();
        $("[data-testid=results-list]").$("a[href='/qaness/demo']").click();
        $("#issues-tab").click();
        $(withText("#1")).should(Condition.exist);
    }
}
