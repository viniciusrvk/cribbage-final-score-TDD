package swtest101.cribbage.service;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import swtest101.cribbage.exception.InvalidHandException;
import swtest101.cribbage.exception.InvalidRankException;
import swtest101.cribbage.exception.InvalidSuitException;

@RunWith(Parameterized.class)
public class ParseStringServiceExceptionalTest {

	@Parameters(name = "Case: {3}")
	public static Collection<Object[]> buildData() {
		return Arrays.asList(new Object[][] { //
//				STRING , EXCEPTION, STATIC_MESSAGE
				{ "JH5C4SQDAH5", InvalidHandException.class, ParseStringService.INVALID_HAND_STRING_ERROR_MSG,
						"More than ten" },
				{ "QC9D2HAHOC", InvalidRankException.class, ParseStringService.INVALID_RANK_CHAR_ERROR_MSG, "Rank O" },
				{ "QC9D2HAHKT", InvalidSuitException.class, ParseStringService.INVALID_SUIT_CHAR_ERROR_MSG,
						"Suit T" } });
	}

	@Rule
	public ExpectedException e = ExpectedException.none();

	@Parameter(0)
	public String input;

	@Parameter(1)
	public Class<? extends Exception> expectedExceptionType;

	@Parameter(2)
	public String expectedErrorMessage;

	@Parameter(3)
	public String name;

	@Test
	public void testParseToListOfCards() {
		e.expect(expectedExceptionType);
		e.expectMessage(expectedErrorMessage);

		ParseStringService.parseToListOfCards(input);
	}

}
