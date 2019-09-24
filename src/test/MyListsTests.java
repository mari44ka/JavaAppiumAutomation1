package test;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListPageObjectFactory;
import lib.ui.factories.NavigatioUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class MyListsTests extends CoreTestCase {

  private static final String name_of_folder = "Learning programming";
  private static final String login ="mari4ka25";
  private static final String password ="K05311983k";

  @Test
  public void testsaveFirstArticleToMyList() {

    SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Java");
    SearchPageObject.clickByArticleWithSubstring("bject-oriented programming language");

    ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

    String article_title = ArticlePageObject.getArticleTitle();
    if(Platform.getInstance().isAndroid()){
    ArticlePageObject.waitForTitleElement();
    ArticlePageObject.addArticleToMyList(name_of_folder);}
    if(Platform.getInstance().isIOS()){
      ArticlePageObject.closeSyncSavedArticle();}
      else {
        ArticlePageObject.addArticleToMySaved();
        NavigationUI NavigationUI = NavigatioUIFactory.get(driver);
        NavigationUI.openNavigation();

        AutharizationPageObject Auth = new AutharizationPageObject(driver);
        Auth.clickAuthButton();
        Auth.enterLoginData(login,password);
        Auth.submitForm();
        ArticlePageObject.waitForTitleElement();
        assertEquals("we are not at the same page after login",
                article_title,
                ArticlePageObject.getArticleTitle());
        ArticlePageObject.addArticleToMySaved();
      }

    ArticlePageObject.closeArticle();

    NavigationUI NavigationUI = NavigatioUIFactory.get(driver);
    NavigationUI.openNavigation();
    NavigationUI.clickMyLists();

    MyLIstPageObject MyLIstPageObject = MyListPageObjectFactory.get(driver);
    if(Platform.getInstance().isAndroid()) {
      MyLIstPageObject.openFolderByName(name_of_folder);
    }
    MyLIstPageObject.swipeArticleToDelete(article_title);


  }
}
