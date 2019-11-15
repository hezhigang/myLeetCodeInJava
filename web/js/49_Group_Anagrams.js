/**
 * @param {string[]} strs
 * @return {string[][]}
 */
var groupAnagrams = function(strs) {
    var m = {};
    for(var i=0;i<strs.length;i++) {
        var s = strs[i];
        var c = s.split("").sort();
        m[c]?m[c].push(s):m[c]=[s];
    }
    var r = [];
    var keys = Object.keys(m);
    for(var k=0; k<keys.length; k++) {
        r.push( m[keys[k]] );
    }
    return r;
};