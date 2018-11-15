type MyLinkedList struct {
    Next  *MyLinkedList
	Value int
	Head  *MyLinkedList
	Tail  *MyLinkedList
}


/** Initialize your data structure here. */
func Constructor() MyLinkedList {
    return MyLinkedList{}
}


/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
func (this *MyLinkedList) Get(index int) int {
    if index < 0 {
		return -1
	}
	t := this.Head
	for i := 0; t != nil && i < index; i++ {
		t = t.Next
	}
	if t != nil {
		return t.Value
	}
	return -1
}


/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
func (this *MyLinkedList) AddAtHead(val int)  {
    temp := &MyLinkedList{
		Next:  this.Head,
		Value: val,
	}
	this.Head = temp
	if this.Tail == nil { // if only one node, head and tail point to the single node
		this.Tail = temp
	}
}


/** Append a node of value val to the last element of the linked list. */
func (this *MyLinkedList) AddAtTail(val int)  {
    temp := &MyLinkedList{
		Next:  nil,
		Value: val,
	}
	if this.Tail != nil {
		this.Tail.Next = temp // if more than one node, update tail of last node
	}
	this.Tail = temp
}


/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
func (this *MyLinkedList) AddAtIndex(index int, val int)  {
    if index < 0 {
		return
	}
    if index == 0 {
		this.AddAtHead(val)
		return
	}
	t := this.Head
	var (
		i    int
		prev *MyLinkedList
	)
	for i = 0; i < index && t != nil; i++ {
		prev = t
		t = t.Next
	}
	if t == nil {
		if i == index {
			this.AddAtTail(val)
		}
		return
	}
	temp := &MyLinkedList{
		Next:  t,
		Value: val,
	}
	prev.Next = temp
}


/** Delete the index-th node in the linked list, if the index is valid. */
func (this *MyLinkedList) DeleteAtIndex(index int)  {
    // check if index is valid
	if index < 0 || this.Head == nil {
		// fmt.Println("no op")
		return
	}
	var (
		prev *MyLinkedList
		i    int
	)
	t := this.Head
	for i = 0; i < index && t != nil; i++ {
		prev = t
		t = t.Next
	}
	if t == nil {
		// fmt.Println("no op")
		return
	}
	if prev == nil {
		// update head
		if this.Head == this.Tail {
			// single node, to be deleted
			this.Head = nil
			this.Tail = nil
		} else {
			this.Head = t.Next
		}
	} else {
		// update other than head
		prev.Next = t.Next
		if prev.Next == nil {
			this.Tail = prev
		}
	}
	t = nil
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Get(index);
 * obj.AddAtHead(val);
 * obj.AddAtTail(val);
 * obj.AddAtIndex(index,val);
 * obj.DeleteAtIndex(index);
 */
