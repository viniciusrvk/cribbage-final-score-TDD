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
public class CalculatePairTest {

	@Parameters(name = "Case: {2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { 
//				INPUT     SCORE    TEST CASE
			{ "5H5D5S5C2H", 12, "6 pair" }, 
			{ "4C4H2D4D3H", 6, "3 pair" },
			{ "4C4H2D8D5H", 2, "1 pair" },
			{ "4C3H2D5D7H", 0, "0 pair" },
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
		final Integer score = ScoringService.calculatePair(hand);

		assertThat("Erro with "+test, score, is(equalTo(expectedScore)));
	}
}
