package swtest101.cribbage.service;

import java.util.Iterator;
import java.util.List;

import swtest101.cribbage.entity.Card;

public class ScoringService {

	public static Integer calculateScore(String handOfCards) {
		Integer score = 0;
		List<Card> cards = ParseStringService.parseToListOfCards(handOfCards);

		sort(cards);

		score += calculatePair(cards);

//		• Straight: Sequência de 3 cartas ou mais – 1 ponto por carta
//		• Flush: 4 ou 5 cartas com o mesmo naipe – 1 ponto por carta
//		• Nob: Se o jogador tiver um valete do mesmo naipe da Start Card – 1 ponto
//		• 15: Qualquer combinação de cartas que some 15 – 2 pontos (Obs.: Para a soma dos 15, as cartas Rei,
//		* Dama e Valete valem 10 e o Ás vale 1)

		return null;
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
//		for(Card current: hand) {
//			if(current.getRank().equals(previous.getRank()+1)) {
//				tmp++;
//				if(tmp > score) {
//					score = tmp;
//				}
//			}
//			else if(!current.getRank().equals(previous.getRank())) {
//				tmp = 1;
//			}
//			previous = current;
//		}
		
		return score > 2 ? score: 0;
	}

	static Integer calculateFlush(List<Card> hand) {
		Integer score = 0;
		return score ;
	}

	static Integer calculate15(List<Card> hand) {
		Integer score = 0;
		return score ;
	}
}
