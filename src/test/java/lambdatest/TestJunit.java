package lambdatest;

import junit.framework.AssertionFailedError;
import junit.framework.TestResult;
import org.junit.Test;

public class TestJunit extends TestResult 
{
	 // add the error
	   public synchronized void addError(Test test, Throwable t) {
	      super.addError((junit.framework.Test) test, t);
	   }

	   // add the failure
	   public synchronized void addFailure(Test test, AssertionFailedError t) {
	      super.addFailure((junit.framework.Test) test, t);
	   }
		
	   @Test
	   public void testAdd() {
	     System.out.println("This is testAdd() method.");
	   }
	   
	   // Marks that the test run should stop.
	   public synchronized void stop() {
	     System.out.println("stop the test here");
	   }
}