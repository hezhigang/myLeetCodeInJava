/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
	var profit = 0;
	var diff = 0;
	for(var i=1;i<prices.length;i++) {
		diff = prices[i]-prices[i-1];
		if (diff>0)
			profit+=diff;
	}
	return profit;    
};