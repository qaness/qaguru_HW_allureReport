import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SelenideTestForAllureSteps {

    @Test
    public void LambdaStepSearchIssueTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Вводим в поиске имя репозитория", () -> {
            $(".search-input").click();
            $("#query-builder-test").setValue("qaness/demo").pressEnter();
        });

        step("Переход к репозиторию", () -> {
            $("[data-testid=results-list]").$("a[href='/qaness/demo']").click();
        });

        step("Переход на вкладку issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверка на наличие issue с номером #1", () -> {
            $(withText("#1")).should(Condition.exist);
        });

    }
}
