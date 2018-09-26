/**
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 */
var coinChange = function(coins, amount) {
	if (amount==0) return 0;
	
	var n=-1;
	var MC = new Array(amount+1);
	MC[0]=0;
	for(var i=1;i<=amount;i++)
		MC[i]=Number.MAX_VALUE;
	
	for(var i=1;i<=amount;i++) {
		for(var j=0;j<coins.length;j++) {
			if (i>=coins[j]) {
				var cc = MC[i-coins[j]];
				if (cc!=Number.MAX_VALUE && (cc+1<MC[i]))
					MC[i] = cc+1;
			}
		}
	}
	n = MC[amount];
	
	if (n==Number.MIN_VALUE || n==Number.MAX_VALUE || n==0) n = -1;
	
	return n;    
};