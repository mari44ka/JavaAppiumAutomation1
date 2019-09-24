package lib.ui;

import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AutharizationPageObject extends MainPageObject {
    private static final String
    LOGIN_BUTTON ="css:a[data-event-name ='login']",
    LOGIN_INPUT = "css:input[name='wpName']",
    PASSWORD_INPUT = "css:input[name='wpPassword']",
    SUBMIT_BUTTON = "css:button[name='wpLoginattempt']";
     public AutharizationPageObject (RemoteWebDriver driver){
         super(driver);
     }


    public void clickAuthButton() {
        if (Platform.getInstance().isMW()) {
            this.tryClickElementWithFewAttempts(
                    LOGIN_BUTTON,
                    "cannot find and click authorization button",
                    5);
        }
    }
    public void enterLoginData(String login, String password){
         this.waitforElementAndSendKeys(LOGIN_INPUT,
                 login,
                 "cannot find and put login input",
                 5);
         this.waitforElementAndSendKeys(PASSWORD_INPUT,
                 password,
                 "cannot find and put password input",
                 5);
    }
    public void submitForm(){
         this.waitforElementAndClick(SUBMIT_BUTTON,
                 "cannot find and click on submit button",
                 5);
    }

}
