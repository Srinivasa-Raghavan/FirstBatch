package learnTestNG;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCase1 extends LearnAnnotation {

	@Test(invocationCount=2)
	public void testCase1_1()
	{
		System.out.println("Am in test case 1_1");
	}
	
	@Test
	public void testCase1_2()
	{
		System.out.println("Am in test case 1_2");
	}
	
	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("Executing @BeforeSuite");
	  }
}
