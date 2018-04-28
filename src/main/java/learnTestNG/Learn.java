package learnTestNG;

import org.testng.annotations.Test;

import wdMethods.SeMethods;

public class Learn extends SeMethods  {
	
/*	@Test(priority=2)
	public void test() {
		
		startApp("Chrome", "https://www.google.com");
		closeAllBrowsers();
	}*/
	
	@Test(priority=1)
	public void test1() {
		
		startApp("Chrome", "https://jqueryui.com/");
		closeAllBrowsers();
	}
	
	@Test(priority=-1, dependsOnMethods= {"learnTestNG.Learn.test1"})
	public void testw() {
		
		startApp("Chrome", "https://www.gmail.com");
		closeAllBrowsers();
	}

}
