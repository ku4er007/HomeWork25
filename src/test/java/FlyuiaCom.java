import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class FlyuiaCom {

    @Test
    public void searchTicketsFlyuiaCom(){
        Configuration.baseUrl = "https://www.flyuia.com";
        Configuration.timeout = 1000;
        open("/");

        $x("//div[@class='value-as-text']").click();
        $x("//div[@class='value-as-text']").val("Vienna");
        $x("//div[contains(text(),' Vienna, Vienna International')]").click();
        $("ng-pristine ng-valid ng-touched").click();
        $("ng-pristine ng-valid ng-touched").val("Kyiv");




    }
}
