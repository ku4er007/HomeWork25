import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FlyuiaCom {

    SelenideElement departureDate = $x("//button[@class='calendar-day calendar-day-btn fx-flex-fill fx-row__center__center'][contains(text(),'19')]");
    SelenideElement returnDate = $x("//button[@class='calendar-day calendar-day-btn fx-flex-fill fx-row__center__center'][contains(text(),'21')]");
    SelenideElement flyDate = $x("//div[@class='search-details__item--text'][contains(text(),'Пн, 26 Окт - Пн, 26 Окт')]");

    @Test
    public void searchTicketsFlyuiaCom() {
        Configuration.baseUrl = "https://www.flyuia.com";
        Configuration.timeout = 1000;
        open("/");

        $x("//div[@class='value-as-text']").click();
        $x("//div[@class='value-as-text']").val("Vienna");
        $x("//div[contains(text(),' Vienna, Vienna International')]").click();
        $$x("//input[@class='ng-valid ng-dirty ng-touched']").get(1).val("Kyiv");
        $x("//div[@class='input-wrapper fx-row__space-between__center focused']").click();
        $x("//i[@class='obe-sw-icon-navigate_next']").click();
        departureDate.click();
        $x("//sw-form-control-datepicker[@class='fx-flex-47 ng-untouched ng-pristine ng-valid']").click();
        returnDate.click();
        $x("//input[@placeholder='select passengers']").click();
        $$x("//button[@class='set-val-btn fx-row__center__center fx-flex-15'][contains(text(),'+')]").get(0).click();
        $x("//input[@id='SEARCH_WIDGET_FORM_INPUTS_SELECT_PASSENGERS']").shouldHave(Condition.text(" 2 Пасажира "));
        $x("//button[@id='SEARCH_WIDGET_FORM_BUTTONS_SEARCH_FLIGHTS']").click();
        $x("//I[@class='icon-close']").click();
        $$x("//div[@class='product__title']").shouldHaveSize(2);
        flyDate.shouldHave(Condition.text("Пн, 26 Окт - Пн, 26 Окт"));

    }
}
