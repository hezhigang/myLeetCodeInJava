/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
	if (prices==null || prices.length<=1)
		return 0;
	var r=0;
	var minPrice = prices[0];
	for(var i=1;i<prices.length;i++) {
		r = Math.max(r,prices[i]-minPrice);
		minPrice = Math.min(minPrice,prices[i]);
	}
	return r;    
};