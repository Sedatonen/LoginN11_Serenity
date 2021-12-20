package pages;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class n11FBPageElements {
    public static Target FB_EMAIL_FIELD = Target.the("facebook email textbox")
            .located(By.id("email"));

    public static Target FB_PASSWORD_FIELD = Target.the("facebook pass textbox")
            .located(By.id("pass"));

    public static Target FB_LOGIN_BTN = Target.the("facebook login btn")
            .located(By.name("login"));
}
