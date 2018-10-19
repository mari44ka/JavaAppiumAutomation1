package lib.ui;

import io.appium.java_client.AppiumDriver;


/**
 * Created by Mari on 10/17/18.
 */
public class WelcomePageObject extends MainPageObject {

  private static final String
  STEP_LEARN_MORE_LINK ="id:Learn more about Wikipedia",
  STEP_NEW_WAYS_TO_EXPLORE = "id:New ways to explore",
  STEP_ADD_OR_EDIT_PREFIRRED_LANGUAGES = "id:Add or edit preferred languages",
  STEP_LEARN_MORE_ABOUT_DATA_COLLECTED = "id:Learn more about data collected",
  STEP_GET_STARTED = "id:Get started",
  STEP_NEXT = "id:Next",
  STEP_SKIP = "id:Skip";

  public WelcomePageObject(AppiumDriver driver){
    super(driver);
  }

  public void waitForLearnMoreLink(){
    this.WaitforElementPresent(
            STEP_LEARN_MORE_LINK,
            "cannot find learn more about wikipedia link",
            5);
  }
  public void waitForNewWayToExploreText(){
    this.WaitforElementPresent(
            STEP_NEW_WAYS_TO_EXPLORE,
            "cannot find 'New ways to explore' link",
            5);
  }
  public void waitForAddOrEditPrefirredLangText(){
    this.WaitforElementPresent(
            STEP_ADD_OR_EDIT_PREFIRRED_LANGUAGES,
            "cannot find 'Add or edit preferred languages' link",
            5);
  }
  public void waitForLearnMoreAboutDataCollectedText(){
    this.WaitforElementPresent(
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED,
            "cannot find 'Learn more about data collected' link",
            5);
  }

  public void clickNextButton()
  {
    this.waitforElementAndClick(
            STEP_NEXT,
            "cannot find Next link",
            5);
  }

  public void clickgetStartedButton(){
    this.waitforElementAndClick(
            STEP_GET_STARTED,
            "cannot find 'Get started' link",
            5);
  }

  public void clickSkipButton(){
    this.waitforElementAndClick(
            STEP_SKIP,
            "cannot find 'Skip' button",
            5);
  }



}

