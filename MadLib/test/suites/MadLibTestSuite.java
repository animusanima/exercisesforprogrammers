package suites;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import prompterTests.PrompterTest;
import readerTests.InputReaderTest;

/**
 *
 * @author animusanima
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({PrompterTest.class, InputReaderTest.class})
public class MadLibTestSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
