package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.entity.Card;

public class Calculate15 {
	@Parameters(name = "Case: {2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { 
//				INPUT      SCORE   CASE TEST
			{ "2H3D4S5C6H", 2, "2+3+6+4 4+5+6  " }, 
			{ "4C4H2D4D2H", 0, "No comb" },
			{ "4C4H2D5D2H", 1, "3 straight" },
			{ "5C5H0D5D5S", 10, "(10+5)4 (5+5+5)6" },
			{ "5C5HJD5D5S", 10, "(10+5)4 (5+5+5)6" },
			{ "5C5HQD5D5S", 10, "(10+5)4 (5+5+5)6" },
			{ "5C5HKD5D5S", 10, "(10+5)4 (5+5+5)6" },
																													// pair
		});
	}

	@Parameter(0)
	public String input;

	@Parameter(1)
	public Integer expectedScore;
	
	@Parameter(2)
	public String test;

	@Test
	public void shouldScoreByPair() {
		List<Card> hand = ParseStringService.parseToListOfCards(input);
		final Integer score = ScoringService.calculate15(hand);

		assertThat("Erro with "+test, score, is(equalTo(expectedScore)));
	}
}
