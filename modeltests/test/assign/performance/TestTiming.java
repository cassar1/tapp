package test.assign.performance;
import test.assign.models.TestVM;
import nz.ac.waikato.modeljunit.gui.ExampleModels;

import com.clarkware.junitperf.*;

import junit.framework.Test;

import com.clarkware.junitperf.TimedTest;

public class TestTiming {
        
public static Test suite() {
        
        long maxElapsedTime = 5500;
        Test testCase = new TestPerf("testFsm");
        TimedTest timedTest = new TimedTest(testCase, maxElapsedTime);
        
        return timedTest;
    }
    
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}
