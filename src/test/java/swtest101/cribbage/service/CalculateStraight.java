package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.entity.Card;

@RunWith(Parameterized.class)
public class CalculateStraight {

	@Parameters(name = "Case: {2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { 
//				INPUT      SCORE   CASE TEST
			{ "2H3D4S5C6H", 5, "Full straight " }, 
			{ "4C4H2D4D2H", 4, "4 straight" },
			{ "4C4H2D8D2H", 3, "3 straight" },
			{ "4C3H2D5D2H", 0, "No straight" },
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
		final Integer score = ScoringService.calculateStraight(hand);

		assertThat("Erro with "+test, score, is(equalTo(expectedScore)));
	}
}
