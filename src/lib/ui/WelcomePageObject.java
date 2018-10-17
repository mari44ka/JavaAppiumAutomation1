package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Mari on 10/17/18.
 */
public class WelcomePageObject extends MainPageObject {

  private static final String
  STEP_LEARN_MORE_LINK ="Learn more about Wikipedia",
  STEP_NEW_WAYS_TO_EXPLORE = "New ways to explore",
  STEP_ADD_OR_EDIT_PREFIRRED_LANGUAGES = "Add or edit preferred languages",
  STEP_LEARN_MORE_ABOUT_DATA_COLLECTED = "Learn more about data collected",
  STEP_GET_STARTED = "Get started",
  STEP_NEXT = "Next";
  public WelcomePageObject(AppiumDriver driver){
    super(driver);
  }

  public void waitForLearnMoreLink(){
    this.WaitforElementPresent(
            By.id(STEP_LEARN_MORE_LINK),
            "cannot find learn more about wikipedia link",
            5);
  }
  public void waitForNewWayToExploreText(){
    this.WaitforElementPresent(
            By.id(STEP_NEW_WAYS_TO_EXPLORE),
            "cannot find 'New ways to explore' link",
            5);
  }
  public void waitForAddOrEditPrefirredLangText(){
    this.WaitforElementPresent(
            By.id(STEP_ADD_OR_EDIT_PREFIRRED_LANGUAGES),
            "cannot find 'Add or edit preferred languages' link",
            5);
  }
  public void waitForLearnMoreAboutDataCollectedText(){
    this.WaitforElementPresent(
            By.id(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED),
            "cannot find 'Learn more about data collected' link",
            5);
  }

  public void clickNextButton(){
    this.waitforElementAndClick(By.id(STEP_NEXT),"cannot find Next link",5);
  }
  public void clickgetStartedButton(){
    this.waitforElementAndClick(By.id(STEP_GET_STARTED),"cannot find 'Get started' link",5);
  }



}

