from objects.BestPokerHand import BestPokerHand

def main():

    # 2347. Best Poker Hand
    # ranks = [13, 2, 3, 1, 9]
    # suits = ["a", "a", "a", "a", "a"]
    # ranks = [4, 4, 2, 4, 4]
    # suits = ["d", "a", "a", "b", "c"]
    ranks = [10,10,2,12,9]
    suits = ["a", "b", "c", "a", "d"]
    obj = BestPokerHand()
    print("Best Poker Hand is " + obj.bestHand(ranks, suits))

if __name__ == '__main__':
    main()