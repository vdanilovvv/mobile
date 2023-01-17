import extensions.AppiumExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.UserListPage;

@ExtendWith(AppiumExtension.class)
public class TestPosts {
  private UserListPage ulp = new UserListPage();


  @Test
  public void testPostsNumber() throws InterruptedException {
    ulp.open()
        .openPostListPage()
        .assertPostListSize(100);
    Thread.sleep(2000);
  }
}
