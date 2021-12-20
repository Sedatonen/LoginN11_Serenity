package pages;

import net.serenitybdd.screenplay.targets.Target;

public class n11BasePageElements {
    public static Target LOGIN_LINK = Target.the("login link")
            .locatedBy(".btnSignIn");

    public static Target USERNAME_LINK = Target.the("username link")
            .locatedBy(".menuLink.user");
}
