/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    if (nums.length < 2) return nums.length;
    for (var i = 0; i < nums.length; i++) {
        while (nums[i] === nums[i-1])
            nums.splice(i, 1);
    }
    return nums.length;
};