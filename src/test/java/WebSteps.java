import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage(){
        open("https://github.com/");
    }

    @Step("Вводим в поиске имя репозитория qaness/demo")
    public void searchRepository(){
        $(".search-input").click();
        $("#query-builder-test").setValue("qaness/demo").pressEnter();
    }

    @Step("Переход к репозиторию qaness/demo")
    public void clickOnRepositoryLink(){
        $("[data-testid=results-list]").$("a[href='/qaness/demo']").click();
    }

    @Step("Переход на вкладку issues")
    public void openIssuesTab(){
        $("#issues-tab").click();
    }

    @Step("Проверка на наличие issue с номером #1")
    public void shouldSeeIssueWithNumber(){
        $(withText("#1")).should(Condition.exist);
    }

}
