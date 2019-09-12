package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ScoringServiceTest {

	@Parameters(name = "Case: {2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { 
//				INPUT      SCORE   CASE TEST
			 { "2H3D4S5C6H", 9, "Score: 4  " }
			,{ "4C4H2D4D2H", 8, "Score: 0" }
			,{ "4C4H2D5D2H", 8, "Score: 4" }
			,{ "5H0D3C5C0H", 12, "Score: 8" }
			,{ "5H5D3C0H5C", 14, "Score: 8" }
			,{ "5C5HKD5D5S", 28, "Score: 16" }
			,{ "3D5H5D2DKD", 14, "Score: 14"}
		});
	}

	@Parameter(0)
	public String input;

	@Parameter(1)
	public Integer expectedScore;
	
	@Parameter(2)
	public String test;
	
	@Test
	public void testCalculateScore() {
		final Integer score = ScoringService.calculateScore(input);

		assertThat("Erro with "+test, score, is(equalTo(expectedScore)));
	}

}
