
import lib.CoreTestCase;
import lib.ui.*;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


/**
 * Created by Mari on 9/20/18.
 */
public class FirstTest extends CoreTestCase {

  private MainPageObject MainPageObject;

  protected void setUp() throws Exception {
    super.setUp();
    MainPageObject = new MainPageObject(driver);
  }

  @Test
  public void testSearch() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);


    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForSearchResult("Object-oriented programming language");


  }

  @Test
  public void testCancelSearch()

  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.waitForCanselButtonToAppear();
    SearchPageObject.clickCanselSearch();
    SearchPageObject.waitForCanselButtonToDisappear();

  }

  @Test
  public void testCompareArticleTitle() {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String article_title = ArticlePageObject.getArticleTitle();

    Assert.assertEquals(
            "we cannot see expected title",
            "Java (programming language)",
            article_title);


  }

  @Test

  public void testSwipeArticle() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.swipeToFooter();

  }

  @Test
  public void testsaveFirstArticleToMyList() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);

    String article_title = ArticlePageObject.getArticleTitle();
    String name_of_folder = "Learning programming";

    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addArticleToMyList(name_of_folder);
    ArticlePageObject.closeArticle();

    NavigationUI NavigationUI = new NavigationUI(driver);
    NavigationUI.clickMyLists();

    MyLIstPageObject MyLIstPageObject = new MyLIstPageObject(driver);
    MyLIstPageObject.openFolderByName(name_of_folder);
    MyLIstPageObject.swipeArticleToDelete(article_title);

  }

  @Test
  public void testAmountOfNotEmptySearch() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();

    String search_line = "Linkin park discography";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.getAmountOfFoundArticles();

    int amountOfSearchResults = SearchPageObject.getAmountOfFoundArticles();
    Assert.assertTrue("we found too few results",
            amountOfSearchResults > 0);

  }

  @Test
  public void testAmountOfEmptySearch() {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();

    String search_line = "fjsdljf";

    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.waitForEmptyResultsLabel();
    SearchPageObject.assertThereIsNoResultOfSearch();

  }

  @Test

  public void testChangeScreenOrientationOnSearchResult()
  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String title_before_rotation = ArticlePageObject.getArticleTitle();

    this.rotateScreenlandscape();

    String title_after_rotation = ArticlePageObject.getArticleTitle();

    this.rotateScreenPortrait();
    String title_after_second_rotation =ArticlePageObject.getArticleTitle();


    Assert.assertEquals("Article title have benn changed after screen rotation",
            title_before_rotation,
            title_after_second_rotation);


  }

  @Test
  public void testCheckSearchArticleInBackground()
  {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    String search_line = "Java";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");
    this.backgroundApp(8);
    SearchPageObject.waitForSearchResult("Object-oriented programming language");

  }



}














