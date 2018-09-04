/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
	  if (numRows==1) {
		  return [[1]];
	  }
	  if (numRows==2) {
		  return [[1],[1,1]];
	  }
	  var arr = [];
	  if (numRows>=3) {
		  var arr_ = generate(numRows-1);
		  var line_pre = arr_[numRows-2];
		  for(i=0;i<arr_.length;i++)
			  arr.push(arr_[i]);
		  var line_curr = [1];
		  for(i=1;i<numRows-1;i++) {
			  line_curr.push(line_pre[i]+line_pre[i-1]);
		  }
		  line_curr.push(1);
		  arr.push(line_curr);
	  }
	  return arr;    
};