
class Solution {
	public static ListNode removeNthFromEnd(ListNode head, int n) throws Exception {
		ListNode dummyHeader = new ListNode(0, head);

		ListNode later = dummyHeader;
		ListNode ealier = dummyHeader;

		for (int i = 0; i < n; i++) {
			later = later.next;
			// check to see if n is too large
			if (later.next == null)
				if (i != n - 1)
					throw new Exception("Value of 'n' is too large.");
		}

		while (later.next != null) {
			later = later.next;
			ealier = ealier.next;
		}

		ealier.next = ealier.next.next;

		return dummyHeader.next;

	}

	// Driver code
	public static void main(String[] args) throws Exception {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		five.next = null;

		// test two
		ListNode testSingle = new ListNode(1, null);

		// test one
		toString(removeNthFromEnd(one, 5));

		// break between test two
		System.out.println();

		// test two
		toString(removeNthFromEnd(testSingle, 1)); // should return an empty string

	}

	public static void toString(ListNode address) {
		System.out.print("[");
		while (address != null) {
			System.out.print(address.val+",");
			address = address.next;
		}
		System.out.print("]");
	}
}
