package login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.Switch;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import pages.n11BasePageElements;
import pages.n11FBPageElements;
import pages.n11LoginPageElements;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class LoginWithFacebook implements Task {

    private final String email_text;
    private final String password_text;

    @Step("{0} Login with email '#email_text' and password '#password_text'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(n11BasePageElements.LOGIN_LINK),
                WaitUntil.the(n11LoginPageElements.FACEBOOK_BTN, isClickable()).forNoMoreThan(3).seconds(),
                Click.on(n11LoginPageElements.FACEBOOK_BTN),
                Switch.toNewWindow(),
                Click.on(n11FBPageElements.FB_EMAIL_FIELD),
                SendKeys.of(this.email_text).into(n11FBPageElements.FB_EMAIL_FIELD),

                Click.on(n11FBPageElements.FB_PASSWORD_FIELD),
                SendKeys.of(this.password_text).into(n11FBPageElements.FB_PASSWORD_FIELD),

                Click.on(n11FBPageElements.FB_LOGIN_BTN),
                Switch.toTheOtherWindow(),
                WaitUntil.the(n11BasePageElements.USERNAME_LINK, isClickable()).forNoMoreThan(5).seconds()
        );
    }

    public LoginWithFacebook(String email_text, String password_text) {
        this.email_text = email_text;
        this.password_text = password_text;

    }

    public static LoginWithFacebook loginThePage(String email_text, String password_text) {
        return instrumented(LoginWithFacebook.class
                , email_text, password_text);
    }

}
//if (n11FBPageElements.FB_VERİFY_BTN.isVisibleFor(actor)) {
//     actor.attemptsTo(
//             WaitUntil.the(n11FBPageElements.FB_VERİFY_BTN, isClickable()).forNoMoreThan(8).seconds(),
//             Click.on(n11FBPageElements.FB_VERİFY_BTN),
//             Switch.toTheOtherWindow(),
//             WaitUntil.the(n11FBPageElements.FB_ACCEPTCONTRACT, isClickable()).forNoMoreThan(8).seconds(),
//             Click.on(n11FBPageElements.FB_ACCEPTCONTRACT),
//             Click.on(n11FBPageElements.FB_ACCEPTCONTACT),
//             Click.on(n11FBPageElements.FB_ACCEPT_BTN)
//     );
// } else {
//     actor.attemptsTo(
//             Switch.toTheOtherWindow()
//     );
// }

