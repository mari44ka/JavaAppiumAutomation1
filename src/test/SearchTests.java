package test;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

/**
 * Created by Mari on 10/12/18.
 */
public class SearchTests extends CoreTestCase {
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
  public void testAmountOfNotEmptySearch() {

    SearchPageObject SearchPageObject = new SearchPageObject(driver);
    SearchPageObject.initSearchInput();

    String search_line = "Linkin park discography";
    SearchPageObject.typeSearchLine(search_line);
    SearchPageObject.getAmountOfFoundArticles();

    int amountOfSearchResults = SearchPageObject.getAmountOfFoundArticles();
    assertTrue("we found too few results",
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
}
