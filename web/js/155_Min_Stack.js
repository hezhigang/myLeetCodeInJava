/**
 * initialize your data structure here.
 */
var MinStack = function(stk,minStk) {
	this.stk = [];
	this.minStk = [];    
};

/** 
 * @param {number} x
 * @return {void}
 */
MinStack.prototype.push = function(x) {
    this.stk.push(x);
    if (this.minStk.length==0 || this.minStk[this.minStk.length-1]>=x)
    	this.minStk.push(x);
};

/**
 * @return {void}
 */
MinStack.prototype.pop = function() {
    var x = this.stk.pop();
    if (x==this.minStk[this.minStk.length-1])
    	this.minStk.pop();
};

/**
 * @return {number}
 */
MinStack.prototype.top = function() {
    return this.stk[this.stk.length-1];
};

/**
 * @return {number}
 */
MinStack.prototype.getMin = function() {
    return this.minStk[this.minStk.length-1];
};

/** 
 * Your MinStack object will be instantiated and called as such:
 * var obj = Object.create(MinStack).createNew()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */