package swtest101.cribbage.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses(value = { 
						ParseToCardTest.class, 
						ParseToCardExceptionalTest.class, 
						ParseStringServiceTest.class, 
						ParseStringServiceExceptionalTest.class,
						CalculatePairTest.class, 
						CalculateStraight.class,
						CalculateFlush.class,
						Calculate15.class,
						ScoringServiceTest.class
						})
public class AllTests {

}
