class MaxConsecutiveOnes:

    # 485. Max Consecutive Ones
    # https://leetcode.com/problems/max-consecutive-ones/
    # 42 / 42 test cases passed.
    # Runtime: 957 ms, faster than 14.08% of Python3 online submissions for Max Consecutive Ones.
    # Memory Usage: 14.6 MB, less than 6.75% of Python3 online submissions for Max Consecutive Ones.
    def findMaxConsecutiveOnes(self, nums):
        countArr = [0] * len(nums)
        if nums[0] == 1:
            countArr[0] = 1
        else:
            countArr[0] = 0
        i = 1
        while i < len(nums):
            if nums[i] == 1:
                if nums[i - 1] == nums[i]:
                    countArr[i] = countArr[i - 1] + 1
                else:
                    countArr[i] = 1
            else:
                countArr[i] = 0
            i += 1
        return max(countArr)