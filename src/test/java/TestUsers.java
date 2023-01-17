import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.UserListPage;

@ExtendWith(AppiumExtension.class)
public class TestUsers {
  private UserListPage ulp = new UserListPage();

  @Test
  public void testRandomUser() throws InterruptedException {
    ulp.open()
        .clickRandom();
  }
}
