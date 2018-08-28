/**
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
	  var n = 0;
	  var len = s.length;
	  for(var i=s.length-1;i>=0;i--) {
		  n+=(s.charCodeAt(i)-64)*Math.pow(26,len-i-1);
	  }
	  return n;	
};