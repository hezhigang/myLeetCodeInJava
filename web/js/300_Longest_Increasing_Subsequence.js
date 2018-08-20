/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function(nums) {
  if (nums==null || nums.length==0)
      return 0;
  var arr = new Array(nums.length);
  for(i=0;i<arr.length;i++)
    arr[i] = 0;
	arr[0] = 1;
  for(i=1;i<nums.length;i++) {
    for(j=0;j<i;j++) {
	  if (nums[j]<nums[i] && arr[j]>arr[i]) {
	    arr[i] = arr[j];
	  }
	}
	arr[i]++;
  }
  var maxLISLen = arr[0];
  for(var i=1;i<arr.length;i++) {
    if (arr[i]>maxLISLen) 
	  maxLISLen = arr[i];
  }
  return maxLISLen;    
};