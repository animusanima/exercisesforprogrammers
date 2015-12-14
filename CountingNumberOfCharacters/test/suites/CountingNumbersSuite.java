package suites;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CharacterCounterTest;
import tests.ValidationTest;
import tests.WordLengthTest;

/**
 *
 * @author animusanima
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ValidationTest.class, CharacterCounterTest.class,
    WordLengthTest.class})
public class CountingNumbersSuite {

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