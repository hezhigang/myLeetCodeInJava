/**
 * @param {string} text1
 * @param {string} text2
 * @return {number}
 */
var longestCommonSubsequence = function(text1, text2) {
    var LEN1 = text1.length, LEN2 = text2.length;
    var C = [];
    for (var i = 0; i <= LEN1; i++) {
        C.push([]);
        for (var j = 0; j <= LEN2; j++) {
            C[i].push(0);
        }
    }
    for (var i = 1; i <= LEN1; i++) {
        for (var j = 1; j <= LEN2; j++) {
            if (text1[i - 1] == text2[j - 1]) {
                C[i][j] = C[i - 1][j - 1] + 1;
            } else {
                C[i][j] = C[i - 1][j] > C[i][j - 1] ? C[i - 1][j] : C[i][j - 1];
            }
        }
    }
    return C[LEN1][LEN2];
};