package test;

import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import com.ibm.integration.test.v1.NodeSpy;
import com.ibm.integration.test.v1.SpyObjectReference;
import com.ibm.integration.test.v1.TestMessageAssembly;
import com.ibm.integration.test.v1.TestSetup;
import com.ibm.integration.test.v1.exception.TestException;

import static com.ibm.integration.test.v1.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class MyApplicationUnderTest_MyFlowUnderTest_UnitTests {

	// TestCase01: Test the MappingError node to ensure it transforms data correctly
	// TestCase02: Test the Route node to ensure a message with Country=FR is routed to the default output terminal
	// TestCase03: Test the MappingDefault node to ensure it transforms data correctly
	// TestCase04: Test the Route node to ensure a message with Country=GB is routed to the GB output terminal
	// TestCase05: Test the MappingGB node to ensure it transforms data correctly
	// TestCase06: Test the Route node to ensure a message with Country=US is routed to the US output terminal
	// TestCase07: Test the MappingUS node to ensure it transforms data correctly
	// TestCase08: Test the Route node to ensure a message with Country=DE is routed to the DE output terminal
	// TestCase09: Test the MappingDE node to ensure it transforms data correctly
		
    @AfterEach
    public void cleanupTest() throws TestException {
        // Ensure any mocks created by a test are cleared after the test runs 
        TestSetup.restoreAllMocks();
    }

	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase01() throws TestException {
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Mapping Error");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase01_MappingErrorIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase01_MappingErrorOut.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}    
	
	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase02() throws TestException {
	
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Route");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase02_RouteDefault.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("default", 1));

	}
	
	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase03() throws TestException {
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Mapping Default");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase03_MappingDefaultIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase03_MappingDefaultOut.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}

	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase04() throws TestException {
	
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Route");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase04_RouteIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("GB", 1));

	}
	
	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase05() throws TestException {
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Mapping GB");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase05_MappingGBIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase05_MappingGBOut.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}

	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase06() throws TestException {
		
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Route");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase06_RouteIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("US", 1));

	}

    @Test
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase07() throws TestException {

		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Mapping US");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase07_MappingUSIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase07_MappingUSOut.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}
	
    @Test	    	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase08() throws TestException {
		
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Route");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase08_RouteIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("DE", 1));

	}

	@Test	
	public void MyApplicationUnderTest_MyFlowUnderTest_TestCase09() throws TestException {
		// Define the SpyObjectReference
		SpyObjectReference nodeReference = new SpyObjectReference().application("MyApplicationUnderTest").messageFlow("MyFlowUnderTest").node("Mapping DE");

		// Initialise a NodeSpy
		NodeSpy nodeSpy = new NodeSpy(nodeReference);

		// Declare a new TestMessageAssembly object for the message being sent into the node
		TestMessageAssembly inputMessageAssembly = new TestMessageAssembly();

		// Create a Message Assembly from the input data file
		try {
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase09_MappingDEIn.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			inputMessageAssembly.buildFromRecordedMessageAssembly(messageStream);
		} catch (Exception ex) {
			throw new TestException("Failed to load input message", ex);
		}

		// Call the message flow node with the Message Assembly
		nodeSpy.evaluate(inputMessageAssembly, true, "in");

		// Assert the number of times that the node is called
		assertThat(nodeSpy, nodeCallCountIs(1));

		// Assert the terminal propagate count for the message
		assertThat(nodeSpy, terminalPropagateCountIs("out", 1));

		/* Compare Output Message 1 at output terminal out */

		try {
			TestMessageAssembly actualMessageAssembly = null;
			TestMessageAssembly expectedMessageAssembly = null;

			// Get the TestMessageAssembly object for the actual propagated message
			actualMessageAssembly = nodeSpy.propagatedMessageAssembly("out", 1);

			// Assert output message body data
			// Get the TestMessageAssembly object for the expected propagated message
			expectedMessageAssembly = new TestMessageAssembly();

			// Create a Message Assembly from the expected output mxml resource
			String messageAssemblyPath = "/MyFlowUnderTest_TestCase09_MappingDEOut.mxml";
			InputStream messageStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(messageAssemblyPath);
			if (messageStream == null) {
				throw new TestException("Unable to locate message assembly file: " + messageAssemblyPath);
			}
			expectedMessageAssembly.buildFromRecordedMessageAssembly(messageStream);

			// Assert that the actual message tree matches the expected message tree
			assertThat(actualMessageAssembly, equalsMessage(expectedMessageAssembly));

		} catch (Exception ex) {
			throw new TestException("Failed to compare with expected message", ex);
		}

	}
    
    
}

	

