package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.collections4.ListUtils;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import extensions.AppiumExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getAndCheckWebDriver;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@ExtendWith(AppiumExtension.class)
public abstract class BasePage{


  public UserListPage openUserListPage(){
    $(By.xpath("//*[contains(@content-desc,'Пользователи')]")).click();
    return new UserListPage();
  }

  public PostListPage openPostListPage(){
    $(By.xpath("//*[contains(@content-desc,'Посты')]")).click();
    return new PostListPage();
  }

  public ElementsCollection getShortList(){
    return $$(By.xpath("//*[@class='android.widget.ScrollView']/*"));
  }

  public List<SelenideElement> getPageList() throws InterruptedException {


    AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();



    List <SelenideElement> listPrev = new ArrayList<>(getShortList());
    List <SelenideElement> listFinal = new ArrayList<>(listPrev);
    Boolean isEnd = false;
    while (isEnd.equals(false)){

      TouchAction action = new TouchAction(null);
      int x = listPrev.get(listPrev.size()-1).getLocation().getX();
      int y = listPrev.get(listPrev.size()-1).getLocation().getY();
      action.press(PointOption.point(x,y)).moveTo(PointOption.point(0,0)).release().perform();

//        listFinal.addAll(listNow);
      List<SelenideElement> listNow = new ArrayList<>(getShortList());

      for (SelenideElement selenideElement : listNow) {
        listFinal.add(selenideElement);
      }
        if (listNow.equals(listPrev)){
          isEnd=true;
        } else {
          listPrev = listNow;
        }
    }
    return listFinal.stream().distinct().collect(Collectors.toList());
  }

}
