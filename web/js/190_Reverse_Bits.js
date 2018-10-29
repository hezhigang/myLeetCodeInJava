/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
	//[leetcode]190. Reverse Bits -- JavaScript 代码
	//https://blog.csdn.net/u014328357/article/details/52382112
	// n = 10 ，11 返回结果不对，但LeetCode上却通过了，不懂？
    var result = 0;
    for (var i = 0; i < 32; ++i) {
        result |= (n >> i & 0x1) << (31 - i); 
    }
    return result >>> 0;    
};