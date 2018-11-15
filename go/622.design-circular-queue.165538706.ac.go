type MyCircularQueue struct {
    Cache []int
    FrontPos int // always points to the next position of insert op
    RearPos int // always points to the next position of delete op
    Capacity int
}


/** Initialize your data structure here. Set the size of the queue to be k. */
func Constructor(k int) MyCircularQueue {
    var myCircularQ MyCircularQueue
    myCircularQ.Cache = make([]int, k)
    for i := 0; i < k; i++{
        myCircularQ.Cache[i] = -1
    }
    myCircularQ.FrontPos = 0
    myCircularQ.RearPos = 0
    myCircularQ.Capacity = k
    return myCircularQ
}


/** Insert an element into the circular queue. Return true if the operation is successful. */
func (this *MyCircularQueue) EnQueue(value int) bool {
    if this.IsFull() {
        return false
    }
    this.Cache[this.FrontPos] = value
    this.FrontPos = (this.FrontPos+1)%(this.Capacity)
    return true
}


/** Delete an element from the circular queue. Return true if the operation is successful. */
func (this *MyCircularQueue) DeQueue() bool {
    if this.IsEmpty() {
        return false
    }
    this.Cache[this.RearPos] = -1
    this.RearPos = (this.RearPos+1)%(this.Capacity)
    return true
}


/** Get the front item from the queue. */
func (this *MyCircularQueue) Front() int {
    return this.Cache[this.RearPos]
}


/** Get the last item from the queue. */
func (this *MyCircularQueue) Rear() int {
    if this.FrontPos == 0 {
        return this.Cache[this.Capacity-1]
    }
    return this.Cache[this.FrontPos-1]
}


/** Checks whether the circular queue is empty or not. */
func (this *MyCircularQueue) IsEmpty() bool {
    if this.RearPos == this.FrontPos && this.Cache[this.FrontPos] == -1 {
        return true
    }
    return false
}


/** Checks whether the circular queue is full or not. */
func (this *MyCircularQueue) IsFull() bool {
    if this.RearPos == this.FrontPos && this.Cache[this.FrontPos] != -1 {
        return true
    }
    return false
}


/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.EnQueue(value);
 * param_2 := obj.DeQueue();
 * param_3 := obj.Front();
 * param_4 := obj.Rear();
 * param_5 := obj.IsEmpty();
 * param_6 := obj.IsFull();
 */
