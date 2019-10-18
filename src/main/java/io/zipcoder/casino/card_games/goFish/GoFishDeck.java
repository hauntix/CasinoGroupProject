package io.zipcoder.casino.card_games.goFish;


import java.util.Random;

public class GoFishDeck {
	private int _count;
	private GoFishCard[] _hand;
	private static final int Storage = 52;
	private static Random random = new Random();

	GoFishDeck() {
		_hand = new GoFishCard[Storage];
		_count = 0;
	}

	void fillDeck() {
		GoFishCard card;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 13; j++) {
				card = new GoFishCard(j, i);
				this.insertCard(card);
			}
		}
	}

	void insertCard(GoFishCard card) {
		if (_count == _hand.length) {
			GoFishCard[] _temp = new GoFishCard[_count + Storage];
			System.arraycopy(_hand, 0, _temp, 0, _hand.length);
			_hand = _temp;
		}
		_hand[_count] = card;
		_count++;
	}

	GoFishCard deleteValue(int value) {
		GoFishCard temp;
		GoFishCard deleted;
		for (int i = 0; i < _count; i++) {
			temp = _hand[i];
			if (temp.getValue() == value) {
				deleted = temp;
				_hand[i] = _hand[_count - 1];
				_count--;
				return deleted;
			}
		}
		return null;
	}

	GoFishCard deleteAnyCard() {
		if (_count == 0) {
			return null;
		} else {
			int randoIx = random.nextInt(_count);
			GoFishCard temp = _hand[randoIx];
			if (randoIx != _count - 1) {
				_hand[randoIx] = _hand[_count - 1];
				_count--;
			} else {
				_hand[_count - 1] = null;
				_count--;
			}
			return temp;
		}
	}

	int checkBookBeginningDeal() {
		for (int i = 0; i < 4; i++) {
			if (getCount(_hand[i].getValue()) == 4) {
				return _hand[i].getValue();
			}
		}
		return 0;
	}

	int getCount(int value) {
		int occurences = 0;
		for (int i = 0; i < _count; i++) {
			if (_hand[i].getValue() == value) {
				occurences++;
			}
		}
		return occurences;
	}

	int getSize() {
		return _count;
	}

	void sort(){
		int x = _count;
		for (int i = 0; i < x; i++) {
			for (int j = 1; j < x - i; j++) {
				if(_hand[j-1].getValue() > _hand[j].getValue()){
					GoFishCard temp = _hand[j-1];
					_hand[j -1 ] = _hand[j];
					_hand[j] = temp;
				}
			}
		}
	}

	public String toString() {
		if (_count != 0) {
			String result = "User Deck: \n";
			for (int i = 0; i < _count; i++) {
				result = result + _hand[i] + "\n";
			}
			return result;
		}
		return "Empty Hand";
	}

}
