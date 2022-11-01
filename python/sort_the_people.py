from objects.SortThePeople import SortThePeople

def main():

    # 2418. Sort the People
    # names = ["Mary","John","Emma"]
    # heights = [180,165,170]
    names = ["Alice", "Bob", "Bob"]
    heights = [155, 185, 150]
    obj = SortThePeople()
    sortByHeight = obj.sortPeople(names, heights)
    print(','.join(sortByHeight))
    # for str in sortByHeight:
    #     print(str)

if __name__ == '__main__':
    main()