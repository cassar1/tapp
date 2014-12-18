package test.assign.performance;


	import com.clarkware.junitperf.*;
	import junit.framework.Test;

	public class PerformanceTests {

		public static void main(String[] args) {
	        junit.textui.TestRunner.run(suite());
	    }
		
	    public static Test suite() {
	        
	        int users = 5;
	        //long maxElapsedTime = 1500;
	        
	        
	        Test testCase = new TestPerf("testFsm");
	        //Test timedTest = new TimedTest(testCase, maxElapsedTime);
	        Test loadTest = new LoadTest(testCase, users);
	        
	        return loadTest;
	    }
	    
	    
	}

