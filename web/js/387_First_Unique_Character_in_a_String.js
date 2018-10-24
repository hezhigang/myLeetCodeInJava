/**
 * @param {string} s
 * @return {number}
 */
var firstUniqChar = function(s) {
	var count = {};
	for(var i=0;i<s.length;i++) {
		if (typeof count[s[i]]!="undefined" && count[s[i]]!=null) {
			count[s[i]]++;
		}
		else {
			count[s[i]]=1;
		}
	}
	var r=-1;
	for(var i=0;i<s.length;i++) {
		if (count[s[i]]==1) {
			r=i;
			break;
		}
	}
	return r;    
};