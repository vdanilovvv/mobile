package interfaces;

import pages.BasePage;

public interface ListPage {
  <T extends BasePage> T clickRandom() throws InterruptedException;
}
