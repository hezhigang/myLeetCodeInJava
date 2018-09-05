/**
 * @param {number} rowIndex
 * @return {number[]}
 */
var getRow = function(rowIndex) {
	if (rowIndex==0) {
		return [1];
	}
	if (rowIndex==1) {
		return [1,1];
	}
	var arr = [];
	if (rowIndex>=2) {
		arr.push(1);
		var preRow = getRow(rowIndex-1);
		for(var i=1;i<rowIndex;i++)
			arr.push(preRow[i]+preRow[i-1]);
		arr.push(1);
	}
	return arr;    
};