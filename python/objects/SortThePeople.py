import collections

class SortThePeople:

    # 2418. Sort the People
    # https://leetcode.com/problems/sort-the-people/
    # 68 / 68 test cases passed.
    # Runtime: 331 ms, faster than 15.16% of Python3 online submissions for Sort the People.
    # Memory Usage: 14.4 MB, less than 89.07% of Python3 online submissions for Sort the People.
    def sortPeople(self, names, heights):
        d = dict()
        for i in range(len(names)):
            d[heights[i]] = names[i]
        od = collections.OrderedDict(sorted(d.items(), reverse=True))
        result = []
        for key in od:
            result.append(od[key])
        return result