/**
 * @param {number} a
 * @param {number} b
 * @return {number}
 */
var getSum = function(a, b) {
    if (a>0) {
        while(a>0) {
            a--;
            b++
        }        
    }
    if (a<0) {
        while(a<0) {
            a++;
            b--;
        }
    }
    return b;
};