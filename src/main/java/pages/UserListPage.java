package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import interfaces.ListPage;
import org.openqa.selenium.By;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.codeborne.selenide.Selenide.$$;

public class UserListPage extends BasePage implements ListPage {


  public UserListPage open() {
    Selenide.open();
    return this;
  }


  @Override
  public <T extends BasePage> T clickRandom() throws InterruptedException {
    var userList = getPageList();
    System.out.println(getPageList().size());
    Faker faker = new Faker();
    int randomInt = faker.random().nextInt(0, userList.size() - 1);
    userList.get(randomInt).click();
    Thread.sleep(2000);
    return (T) new UserPage();
  }
}
