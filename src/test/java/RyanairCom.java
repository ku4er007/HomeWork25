import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.testng.AssertJUnit.assertTrue;

public class RyanairCom {
    SelenideElement departureDate = $x("//div[@class='details__bottom-bar b2 ng-tns-c24-2 ng-trigger ng-trigger-fadeInOut ng-star-inserted']");

    @Test
    public void searchTicketsRyanairTest() {
        Configuration.baseUrl = "https://www.ryanair.com";
        Configuration.timeout = 1000;
        open("/");

        $(By.id("input-button__departure")).click();
        $(By.id("input-button__departure")).clear();

        $(By.id("input-button__departure")).val("Vienna");
        $$x("//fsw-airport-item[@class='ng-star-inserted']").first().click();
        $(By.id("input-button__destination")).val("Kyiv");
        $x("//fsw-airport-item[@class='ng-star-inserted']").click();

        $x("//div[@data-value='19'][@data-id='2020-11-19']").click();
        $$x("//div[@data-value='21']").get(1).click();
        $$x("//div[@class='counter__button-wrapper--enabled']").get(0).click();
        $x("//ry-spinner[@class='ng-tns-c26-3 ry-spinner--white ry-spinner--small']").click();

        $$x("//h3[@class='header__title']").shouldHaveSize(2);
        $("details__bottom-bar b2 ng-tns-c24-2").shouldHave(Condition.text(" В обидва кінці "));
        assertTrue(departureDate.getText().contains("19 лист."));
        assertTrue(departureDate.getText().contains("21 лист."));

    }
}
