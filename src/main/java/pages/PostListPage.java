package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import interfaces.ListPage;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class PostListPage extends BasePage implements ListPage {


  public void assertPostListSize(Integer expectedSize) throws InterruptedException {
    List<SelenideElement> postList =  getPageList();
    Assertions.assertEquals(expectedSize, postList.size());
  }

  @Override
  public <T extends BasePage> T clickRandom() throws InterruptedException {
    ElementsCollection postList = (ElementsCollection) getPageList();
    Faker faker = new Faker();
    int randomInt = faker.random().nextInt(0, postList.size() - 1);
    postList.get(randomInt).click();
    Thread.sleep(2000);
    return (T) new PostPage();
  }
}
