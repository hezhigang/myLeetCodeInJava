from collections import Counter

class BestPokerHand:

    # 2347. Best Poker Hand
    # https://leetcode.com/problems/best-poker-hand/
    # 98 / 98 test cases passed.
    # Runtime: 58 ms, faster than 42.46% of Python3 online submissions for Best Poker Hand.
    # Memory Usage: 13.8 MB, less than 97.47% of Python3 online submissions for Best Poker Hand.
    def bestHand(self, ranks, suits):
        c = Counter(ranks).values()
        if all(suits[0] == suit for suit in suits):
            return "Flush"
        elif max(c) > 2:
            return "Three of a Kind"
        elif max(c) == 2:
            return "Pair"
        else:
            return "High Card"
