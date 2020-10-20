/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function (nums) {
    var max = nums[0], min = nums[0];
    for (var i = 1; i < nums.length; i++) {
        if (nums[i] > max)
            max = nums[i];
        if (nums[i] < min)
            min = nums[i];
    }
    var lowguard = min - 1;
    var m2 = lowguard;
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] < max && nums[i] > m2)
            m2 = nums[i];
    }
    var m3 = lowguard;
    for (var i = 0; i < nums.length; i++) {
        if (nums[i] < m2 && nums[i] > m3)
            m3 = nums[i];
    }
    return m3 != lowguard ? m3 : max;
};