package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class ArticleTests extends CoreTestCase {

  @Test
  public void testCompareArticleTitle() {
    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
    String article_title = ArticlePageObject.getArticleTitle();

    assertEquals(
            "we cannot see expected title",
            "Java (programming language)",
            article_title);

  }

  @Test

  public void testSwipeArticle() {

    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Appium");
    SearchPageObject.clickByArticleWithSubstring("Appium");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.swipeToFooter();

  }

}
