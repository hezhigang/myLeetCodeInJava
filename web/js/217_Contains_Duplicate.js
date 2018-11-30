/**
 * @param {number[]} nums
 * @return {boolean}
 */
var containsDuplicate = function(nums) {
	var r = false;
	var count = {};
	for(var i=0;i<nums.length;i++) {
		if (typeof count[nums[i]]!="undefined" && count[nums[i]]!=null) {
			count[nums[i]]++;
		}
		else {
			count[nums[i]]=1;
		}
	}
	for(var i in count) {
		if (count[i]>1) {
			r = true;
			break;
		}
	}
	return r;    
};