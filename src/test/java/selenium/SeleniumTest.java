package selenium;

import com.thoughtworks.selenium.*;

import org.testng.annotations.*;

public class SeleniumTest extends SeleneseTestNgHelper {

	@BeforeClass
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*firefox",
				"http://localhost:8080/ossa/login");
		selenium.start();
	}

	@Test
	public void testT() throws Exception {
		selenium.open("/ossa/login");
		selenium.type("id=username", "biljana");
		selenium.type("id=password", "biljana");
		selenium.click("css=input.full-bt");
		selenium.waitForPageToLoad("4000");
		selenium.click("link=Faculty");
		selenium.click("link=Add Faculty");
		selenium.waitForPageToLoad("4000");
		selenium.type("id=name", "Faculty of Smth");
		selenium.type("id=abbreviation", "FSmth");
		selenium.click("css=input.bt.orange");
		selenium.waitForPageToLoad("4000");
		selenium.click("link=Close");
		selenium.waitForPageToLoad("4000");
		selenium.click("id=logout");
		selenium.waitForPageToLoad("4000");

	}

	@AfterClass
	public void tearDown() {
		selenium.stop();
	}
}
