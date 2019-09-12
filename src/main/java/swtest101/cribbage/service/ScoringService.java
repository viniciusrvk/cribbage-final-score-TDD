package swtest101.cribbage.service;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import swtest101.cribbage.entity.Card;
import swtest101.cribbage.entity.Suit;

public class ScoringService {

	public static Integer calculateScore(String handOfCards) {
		Integer score = 0;
		List<Card> cards = ParseStringService.parseToListOfCards(handOfCards);
		for (int i = 1; i < cards.size(); i++) {
			if (cards.get(0).getSuit().equals(cards.get(i).getSuit()) && cards.get(i).getRank().equals(11)) {
				score++;
				break;
			}
		}

		sort(cards);

		score += calculatePair(cards);
		score += calculateStraight(cards);
		score += calculateFlush(cards);
		score += calculate15(cards);

		return score;
	}

//		* Pair: Par de cartas com o mesmo valor – 2 pontos
	static Integer calculatePair(List<Card> cards) {
		Integer score = 0;
		for (Integer i = 0; cards.size() > i; i++) {
			for (Integer j = i; cards.size() > j; j++) {
				if (i != j && cards.get(i).getRank() == cards.get(j).getRank()) {
					score += 2;
				}
			}
		}
		return score;
	}

	private static void sort(List<Card> cards) {
		for (Integer i = 0; cards.size() > i; i++) {
			for (Integer j = i; cards.size() > j; j++) {
				if (cards.get(i).getRank() > cards.get(j).getRank()) {
					Card tmp = cards.get(i);
					cards.set(i, cards.get(j));
					cards.set(j, tmp);
				}
			}
		}
	}

	static Integer calculateStraight(List<Card> hand) {
		Integer score = 1; 
		Integer tmp = 1;
		
		sort(hand);

		Card previous = hand.get(0);
		for (Iterator<Card> iterator = hand.iterator(); iterator.hasNext();) {
			Card next = (Card) iterator.next();
			if(next.getRank().equals(previous.getRank()+1)) {
				tmp++;
				if(tmp > score) {
					score = tmp;
				}
			}
			else if(!next.getRank().equals(previous.getRank())){
				tmp = 1;
			}
			previous = next;	
		}
		
		return score > 2 ? score: 0;
	}

	static Integer calculateFlush(List<Card> hand) {
		Integer score = 0;

		Integer heart = hand.parallelStream().filter(c -> c.getSuit()== Suit.HEARTS).mapToInt(c -> 1).sum();
		Integer clubs = hand.parallelStream().filter(c -> c.getSuit()== Suit.CLUBS).mapToInt(c -> 1).sum();
		Integer diamond = hand.parallelStream().filter(c -> c.getSuit()== Suit.DIAMONDS).mapToInt(c -> 1).sum();
		Integer spade = hand.parallelStream().filter(c -> c.getSuit()== Suit.SPADES).mapToInt(c -> 1).sum();
		
		score = Integer.max(Integer.max(heart, clubs), Integer.max(diamond, spade));
		
		return score > 3 ? score: 0;
	}

	static Integer calculate15(List<Card> hand) {
		Integer score = 0;
		List<Integer> list = hand.stream().map(c -> c.getRank() > 10? 10: c.getRank()).collect(Collectors.toList());
		
		for (int a = 0; a < list.size(); a++) {
			for (int b = a+1; b < list.size(); b++) {
				if(list.get(a)+list.get(b) == 15) {
					score +=2;
				}
				for (int c = b+1; c < list.size(); c++) {
					if(list.get(a)+list.get(b)+list.get(c) == 15) {
						score +=2;
					}
					for (int d = c+1; d < list.size(); d++) {
						if(list.get(a)+list.get(b)+list.get(c)+list.get(d) == 15) {
							score +=2;
						}
						for (int e = d+1; e < list.size(); e++) {
							if(list.get(a)+list.get(b)+list.get(c)+list.get(d)+list.get(e) == 15) {
								score +=2;
							}							
						}
					}
				}
			}
		}
		
		return score ;
	}
}
