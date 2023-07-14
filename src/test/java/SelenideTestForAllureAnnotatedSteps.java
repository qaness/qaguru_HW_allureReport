import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SelenideTestForAllureAnnotatedSteps {
    @Test
    @Feature("Issue в репозитории")
    @Story("Проверка существования Issue")
    @Owner("belovaAV")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поиск Issue неавторизованным пользователем")
    public void testAnnotatedSteps(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchRepository();
        steps.clickOnRepositoryLink();
        steps.openIssuesTab();
        steps.shouldSeeIssueWithNumber();

    }


}
