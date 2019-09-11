package swtest101.cribbage.service;

import static swtest101.cribbage.entity.Suit.CLUBS;
import static swtest101.cribbage.entity.Suit.DIAMONDS;
import static swtest101.cribbage.entity.Suit.HEARTS;
import static swtest101.cribbage.entity.Suit.SPADES;

import java.util.ArrayList;
import java.util.List;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;
import swtest101.cribbage.exception.InvalidCardException;
import swtest101.cribbage.exception.InvalidHandException;
import swtest101.cribbage.exception.InvalidRankException;
import swtest101.cribbage.exception.InvalidSuitException;

public class ParseStringService {

	public static final String INVALID_CARD_STRING_ERROR_MSG = "Input String is invalid. It should have two characters: first is the rank, second is the suit. ";
	public static final String INVALID_RANK_CHAR_ERROR_MSG = "Input char is not a valid Rank: ";
	public static final String INVALID_SUIT_CHAR_ERROR_MSG = "Input char is not a valid Suit: ";
	public static final String INVALID_HAND_STRING_ERROR_MSG = "Input String is invalid. It should have ten characters";

	private static final char TWO_CHAR = '2';
	private static final char NINE_CHAR = '9';
	private static final char TEN_CHAR = '0';

	private static final char ACE_CHAR = 'A';

	private static final char JACK_CHAR = 'J';
	private static final char QUEEN_CHAR = 'Q';
	private static final char KING_CHAR = 'K';

	private static Integer defineRank(final Character rankChar) {
		Integer rank;
		if (rankChar == KING_CHAR) {
			rank = 13;
		} else if (rankChar == QUEEN_CHAR) {
			rank = 12;
		} else if (rankChar == JACK_CHAR) {
			rank = 11;
		} else if (rankChar == ACE_CHAR) {
			rank = 1;
		} else if (rankChar == TEN_CHAR) {
			rank = 10;
		} else if (rankChar >= TWO_CHAR && rankChar <= NINE_CHAR) {
			final String rankStr = String.valueOf(rankChar);
			rank = Integer.valueOf(rankStr);
		} else {
			throw new InvalidRankException(INVALID_RANK_CHAR_ERROR_MSG + rankChar);
		}
		return rank;
	}

	private static Suit defineSuit(final char suitChar) {
		Suit suit;
		if (suitChar == CLUBS.firstChar()) {
			suit = CLUBS;
		} else if (suitChar == DIAMONDS.firstChar()) {
			suit = DIAMONDS;
		} else if (suitChar == HEARTS.firstChar()) {
			suit = HEARTS;
		} else if (suitChar == SPADES.firstChar()) {
			suit = SPADES;
		} else {
			throw new InvalidSuitException(INVALID_SUIT_CHAR_ERROR_MSG + suitChar);
		}
		return suit;
	}

	public static Card parseToCard(String cardStr) {
		if (cardStr.length() != 2) {
			throw new InvalidCardException(INVALID_CARD_STRING_ERROR_MSG);
		}

		final Integer rank = defineRank(cardStr.charAt(0));

		final Suit suit = defineSuit(cardStr.charAt(1));

		final Card card = new Card(rank, suit);

		return card;
	}

	public static List<Card> parseToListOfCards(String handOfCards) {
		if (handOfCards.length() != 10) {
			throw new InvalidHandException(INVALID_HAND_STRING_ERROR_MSG);
		}

		List<Card> cards = new ArrayList<Card>();

		String[] listString = handOfCards.split("(?<=\\G..)");
		for (String string : listString) {
			cards.add(parseToCard(string));
		}

		return cards;
	}

}
