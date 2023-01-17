package providers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.*;

public class SelenideWebDriver implements WebDriverProvider {

  @Nonnull
  @Override
  public WebDriver createDriver(@Nonnull Capabilities capabilities) {
    File apk = new File("src/main/resources/testapp.apk");
    DesiredCapabilities options = new DesiredCapabilities();
//    options.merge(capabilities);
    options.setCapability(MobileCapabilityType.AUTOMATION_NAME,AutomationName.ANDROID_UIAUTOMATOR2);
    options.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
    options.setCapability(MobileCapabilityType.DEVICE_NAME,"TestDeviceAPI");
    options.setCapability(MobileCapabilityType.PLATFORM_NAME,"9.0");
    options.setCapability(MobileCapabilityType.APP,apk.getAbsolutePath());


//    File apk = new File("src/main/resources/testapp.apk");
//    UiAutomator2Options options = new UiAutomator2Options();
//    options.merge(capabilities);
//    options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);
//    options.setPlatformName("Android");
//    options.setDeviceName("TestDeviceAPI");
//    options.setPlatformVersion("9.0");
//    options.setApp(apk.getAbsolutePath());
    try {
      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), options);
      driver.manage().timeouts().implicitlyWait(2,SECONDS);
      return driver;
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }
}

