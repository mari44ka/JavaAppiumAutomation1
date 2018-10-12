package test;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyLIstPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class MyListsTests extends CoreTestCase {
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
}
