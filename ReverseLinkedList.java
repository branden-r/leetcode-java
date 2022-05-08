class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode reversed = null; // let the loop handle node creation
        while (head != null) { // loop as long as the given list has more nodes
            reversed = new ListNode(head.val, reversed); // create a new node in front of the previous node
            head = head.next; // advance the given list
        }
        return reversed;
    }
}