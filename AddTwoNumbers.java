class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(); // begin by creating a false head
        ListNode body = head; // we will handle node initialization inside the loop, and return head.next (true head)

        // this will be a 1 if we need to carry a digit to the next greater place
        int carry = 0; // will be either 0 or 1 due to constraints

        // loop as long as we have at least 1 node remaining in either list
        // or we need to carry a value to the next place
        while (list1 != null || list2 != null || carry > 0) {
            body.next = new ListNode(); // create a node
            body = body.next; // update the object reference to use the new node

            int val1 = 0; // if a list is null, then we don't need to add anything for that list
            int val2 = 0;

            if (list1 != null) {
                val1 = list1.val; // if a list is not null, we need to use the value it gives us
                list1 = list1.next; // advance the list for the next iteration
            }

            if (list2 != null) {
                val2 = list2.val;
                list2 = list2.next;
            }

            int sum = val1 + val2 + carry; // find the sum
            body.val = sum % 10; // update the node we made earlier with the smaller place of the sum
            carry = sum / 10; // check if we need to carry anything to the next greater place
        }
        return head.next; // advance past the false head before returning
    }
}