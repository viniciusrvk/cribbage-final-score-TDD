package swtest101.cribbage.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
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
public class ParseStringServiceTest {

	@Parameters(name = "Case: {2}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
				{ "JH5C4SQDAH", Arrays.asList("JH", "5C", "4S", "QD", "AH"), "Simple case" } });
	}

	@Parameter(0)
	public String input;

	@Parameter(1)
	public List<String> expectedStringList;

	@Parameter(2)
	public String test;

	@Test
	public void checkRank() {
		List<Card> cards = ParseStringService.parseToListOfCards(input);
		// check Rank

		List<Card> expectedCards = new ArrayList<Card>();
		expectedStringList.forEach(str -> expectedCards.add(ParseStringService.parseToCard(str)));

		assertThat(cards, is(equalTo(expectedCards)));

	}
}