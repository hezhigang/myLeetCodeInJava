/**
 * @param {number} n
 * @return {number}
 */
var countPrimes = function(n) {
	if (n<=2) return 0;
	var sqrt = Math.floor(Math.sqrt(n));
	var b = new Array(n);
	b[0]=false;
	b[1]=false;
	for(var i=2;i<n;i++) b[i]=true;
	for(var i=2;i<=sqrt;i++) {
		if (b[i]) {
			for(var j=i*i;j<n;j+=i) {
				b[j]=false;
			}		
		}	
	}
	var x=0;
	for(var i=0;i<n;i++) {
		if (b[i]) x++;
	}
	return x;
};