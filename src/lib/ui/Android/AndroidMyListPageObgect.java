package lib.ui.Android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyLIstPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * Created by Mari on 10/22/18.
 */
public class AndroidMyListPageObgect extends MyLIstPageObject {

  static {
    FOLDER_NAME_TPL ="xpath://*[@text ='{FOLDER_NAME}']";
    ARTICLE_BY_TITLE_TPL ="xpath://*[@text = '{TITLE}']";
  }

  public AndroidMyListPageObgect(RemoteWebDriver driver){
    super(driver);
  }

}
