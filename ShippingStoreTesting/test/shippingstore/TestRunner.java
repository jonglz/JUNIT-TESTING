package shippingstore;

import org.junit.runner.*;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * This Class is used to a Main method call all test classes and run together. 
 * @author Jonathan Gonzalez
 *
 */
public class TestRunner {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestShippingStore.class);
		if ( result.getFailures().size() == 0) {
			System.out.println("All tests successfull! ... ");
		}
		else {
			System.out.println("No. of failed test cases = " + result.getFailures().size());
			for (Failure failure : result.getFailures())
				System.out.println(failure.toString());
		}
	}
} 