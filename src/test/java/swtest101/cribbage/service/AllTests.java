package swtest101.cribbage.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { CalculatePairTest.class, 
						ParseToCardTest.class, 
						ParseToCardExceptionalTest.class, 
						ParseStringServiceTest.class, 
						ParseStringServiceExceptionalTest.class
						})
public class AllTests {

}
