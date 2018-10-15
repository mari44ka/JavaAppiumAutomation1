package testmy;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;


/**
 * Created by Mari on 10/12/18.
 */
public class SearchTests1 extends CoreTestCase {
  @Test
  public void testSearchAndAssertText() {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    String search_test =SearchPageObject.textAtribute();

    assertEquals("we cannot find 'Search...'",
            "Search…",
            search_test);

  }

  @Test
  public void testSearchCancel() {
    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();
    SearchPageObject.typeSearchLine("Google");
    SearchPageObject.clickCanselSearch();
    SearchPageObject.waitForSearchResultNotPresent("Web browser developed by Google");


  }
}
