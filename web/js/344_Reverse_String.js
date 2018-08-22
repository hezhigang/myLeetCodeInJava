/**
 * @param {string} s
 * @return {string}
 */
var reverseString = function(s) {
    var r = "";
    if (s!=null && s.length>0) {
        for(var i=s.length-1;i>=0;i--) {
            r+=s[i];
        }        
    }
    return r;
};