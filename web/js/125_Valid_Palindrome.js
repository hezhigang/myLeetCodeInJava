/**
 * @param {string} s
 * @return {boolean}
 * 480 / 480 test cases passed.
 * Runtime: 102 ms, faster than 45.96% of JavaScript online submissions for Valid Palindrome.
 * Memory Usage: 44.9 MB, less than 61.23% of JavaScript online submissions for Valid Palindrome.
 */
var isPalindrome = function(s) {
    const N = s.length;
    const ALPHANUMERIC = /^[a-z0-9]+$/i;
    let c1, c2;
    for (let i = 0, j = N - 1; i < j; ) {
        c1 = s.charAt(i);
        c2 = s.charAt(j);
        if (!ALPHANUMERIC.test(c1))
            i++;
        else if (!ALPHANUMERIC.test(c2))
            j--;
        else if (c1.toLowerCase() != c2.toLowerCase()) {
            return false;
        } else {
            i++;
            j--;
        }
    }
    return true;
};

/**
 * @param {string} s
 * @return {boolean}
 * 480 / 480 test cases passed.
 * Runtime: 67 ms, faster than 96.43% of JavaScript online submissions for Valid Palindrome.
 * Memory Usage: 44.2 MB, less than 82.85% of JavaScript online submissions for Valid Palindrome.
 */
var isPalindrome_v2 = function(s) {
    let str = s.toLowerCase().replace(/[^a-zA-Z0-9]/g, "");
    const N = str.length;
    for (let i = 0; i < N / 2; i++) {
        if (str.charAt(i) != str.charAt(N - 1 - i))
            return false;
    }
    return true;
};