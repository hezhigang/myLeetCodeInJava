/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
	  for(i=nums.length-1;i>=0;i--) {
		  if (nums[i]==0) {
			  for(j=i+1;j<nums.length;j++) {
			    nums[j-1]=nums[j];
			  }
			  nums[nums.length-1]=0;
		  }
	  } 
};