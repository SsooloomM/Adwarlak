package JUnitTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AdminTesting.class, AllTests.class, BrandTesting.class, StoreTesting.class, UserTesting.class })

public class AllTests {

}
