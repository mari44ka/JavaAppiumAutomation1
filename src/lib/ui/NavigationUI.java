package lib.ui;


import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;




/**
 * Created by Mari on 10/12/18.
 */
abstract public class NavigationUI extends MainPageObject {

  protected static String
          MY_LISTS,
          OPEN_NAVIGATION;

   public NavigationUI(RemoteWebDriver driver) {
    super(driver);
  }

  public void clickMyLists() {
       if(Platform.getInstance().isMW()){
           this.tryClickElementWithFewAttempts(
                   MY_LISTS,
                   "cannot find and click navigation button",
                   5);
       }
    this.waitforElementAndClick(MY_LISTS,
            "cannot find navigation button to my list",
            5);
  }
   public void openNavigation() {
       if (Platform.getInstance().isMW()) {
           this.waitforElementAndClick(OPEN_NAVIGATION,
                   "cannot find and click button navigation",
                   5);
       } else {
           System.out.println("method openNAvigation() do nothing for platform" + Platform.getInstance().getPlatformVar());
       }
   }
}
