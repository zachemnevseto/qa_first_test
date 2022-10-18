package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        String name = "Hanna";
        open("/text-box");

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("[id=userName]").setValue(name);
        $("[id=userEmail]").setValue("hanna@newtest.com");
        $("[id=currentAddress]").setValue("London Baker street 21");
        $("[id=permanentAddress]").setValue("London Baker street 25");
        $("[id=submit]").click();

        $("[id=output]").shouldHave(text(name), text("hanna@newtest.com"),
                text("London Baker street 21"), text("London Baker street 25"));

        System.out.println("HAPPY TESTING");
    }
}