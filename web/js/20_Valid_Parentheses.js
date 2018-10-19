/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
	var pair = {'\}':'\{','\]':'\[',')':'('};
	var stk = new Array();
	var c = '';
	for(var i=0;i<s.length;i++) {
		c = s[i];
		switch(c) {
		case '{':
		case '[':
		case '(':
			stk.push(c);
		    break;
		default:
			if (stk.length==0 || pair[c]!=stk.pop()) {
				return false;
			}
		}	
	}
	if (stk.length==0) return true;
	return false;    
};