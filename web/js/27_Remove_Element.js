/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
    var index = nums.indexOf(val);
    while (index !== -1) {
        index = nums.indexOf(val);
        if (index !== -1)
            nums.splice(index, 1);
    }
    return nums.length;
};

var removeElement2 = function(nums, val) {
    var i=0;
    for(var j=0;j<nums.length;j++) {
        if (nums[j]!=val) {
            nums[i] = nums[j];
            i++;
        }
    }
    return i;
};

var removeElement3 = function(nums, val) {
    for(var i = 0; i < nums.length; i++){
        if ( nums[i] === val) {
            nums.splice(i, 1);
            i--;
        }
    }
    return nums.length;
};

var removeElement4 = function(nums, val) {
    let index
    while((index = nums.indexOf(val)) > -1)
    {
        nums.splice(index, 1)
    }
    return nums.length;
};