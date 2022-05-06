/**
 * @param {number[]} nums
 * @return {number}
 * 63 / 63 test cases passed.
 * Runtime: 123 ms, faster than 5.43% of JavaScript online submissions for Find Peak Element.
 * Memory Usage: 42 MB, less than 73.96% of JavaScript online submissions for Find Peak Element.
 */
var findPeakElement = function(nums) {
    const len = nums.length;
    for (let i = 1; i < len - 1; i++) {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
            return i;
        }
    }
    return nums[0] < nums[len - 1] ? len - 1 : 0;
};