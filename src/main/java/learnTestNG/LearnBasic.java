package learnTestNG;

import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class LearnBasic extends SeMethods{

	@Test
	public void testing() {
		startApp("Chrome","https://jqueryui.com/");
		closeAllBrowsers();
	}
}
