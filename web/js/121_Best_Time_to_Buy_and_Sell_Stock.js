/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
	if (prices==null || prices.length==0)
		return 0;
	var r=0;
	var x = 0;
	for(var i=0;i<prices.length-1;i++) {
		for(var j=prices.length-1;j>i;j--) {
			x = prices[j]-prices[i];
			if (x>r)
				r = x;
		}
	}
	return r;    
};