package selenium;

import com.thoughtworks.selenium.*;

import org.testng.annotations.*;

public class AjaxSeleniumTest extends SeleneseTestNgHelper {
	@BeforeClass
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox",
				"http://jumpstart.doublenegative.com.au");
		selenium.start();
	}

	@Test
	public void testAjaxTestCase1() throws InterruptedException {
		selenium.open("/jumpstart/examples/ajax/form");
		selenium.type("id=firstName", "Biljana");
		selenium.type("id=lastName", "Stanic");
		selenium.click("id=birthday-trigger");
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (selenium.isElementPresent("css=td.selected."))
					break;
			} catch (Exception e) {
			}
			Thread.sleep(1000);
		}

		selenium.click("css=td.selected.");
		selenium.click("css=td.selected.");
		selenium.click("css=div.eg");
		selenium.click("css=input[type=\"submit\"]");
	}

	@AfterClass
	public void tearDown() {
		selenium.stop();
	}
}
