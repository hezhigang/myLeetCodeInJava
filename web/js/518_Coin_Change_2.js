/**
 * @param {number} amount
 * @param {number[]} coins
 * @return {number}
 */
var change = function(amount, coins) {
	var dp = new Array(amount+1);
	for(var i=0;i<dp.length;i++)
		dp[i]=0;
	dp[0]=1;
	for(var i=0;i<amount;i++)
		for(var j=coins[i];j<=amount;++j)
			dp[j]+=dp[j-coins[i]];
	return dp[amount];    
};