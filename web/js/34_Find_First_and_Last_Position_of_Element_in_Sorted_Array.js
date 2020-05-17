/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var searchRange = function(nums, target) {
    var lo = 0, hi = nums.length-1;
    while (lo<=hi) {
        var mid = lo + Math.floor((hi-lo)/2);
        if (target < nums[mid])
            hi = mid-1;
        else if (target > nums[mid])
            lo = mid+1;
        else {
            var startPos = mid, endPos = mid;
            while(startPos>=0 && nums[startPos]==nums[mid]) startPos--;
            while(endPos<=nums.length - 1 && nums[endPos]==nums[mid]) endPos++;
            return [startPos+1, endPos-1];
        }
    }

    return [-1, -1];
};