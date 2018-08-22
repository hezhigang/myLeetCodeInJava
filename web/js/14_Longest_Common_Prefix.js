/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function(strs) {
	  var lcp = "";
	  if (strs==null || strs.length==0)
		  return lcp;
	  var minLen = strs[0].length;
	  var idx = 0;
	  for(var i=1;i<strs.length;i++) {
	    if (strs[i].length<minLen) {
		  minLen = strs[i].length;
		  idx = i;
		}
	  }
	  var lcp = "";
	  var ch = strs[idx].charAt(0);
	  var b = true;
	  for(var i=0;i<strs.length;i++) {
		  b = b && strs[i].charAt(0)==ch?true:false;
	  }
	  if (b) {
		  lcp+=ch;
		  for(var j=1;j<minLen;j++) {
			    ch = strs[idx].charAt(j);
				b = true;
			    for(var i=0;i<strs.length;i++) {
				    b = b && (strs[i].charAt(j)==ch?true:false);
				}
				if (b)
				  lcp += ch;
//				else
//					break;
			  }	  
	  }
	  return lcp;
};