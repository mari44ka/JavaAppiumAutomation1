package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class ArticleTests extends CoreTestCase {

  @Test
  public void testCompareArticleTitle() {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
    String article_title = ArticlePageObject.getArticleTitle();

    assertEquals(
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

}
