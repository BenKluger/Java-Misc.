import java.util.ArrayList;
import java.util.List;

public class Solution2 {
	
	public static boolean isPalindrome(ListNode head) {
		

		
		List<Integer> palindrome = new ArrayList<Integer>();
		
		ListNode pointer = new ListNode();
		pointer = head;
		int count = 0;
		
		for (int i = 0; pointer != null; i++, count++) {
			palindrome.add(i, pointer.val);
			pointer = pointer.next;
		}
		
		 for (int i = 0, j = palindrome.size()-1; i <= count/2 && j >= count/2; i++, j--) { 
			 if(palindrome.get(i) == palindrome.get(j))
				 continue;
			 else
				 return false;
	        } 
		 return true;
		
	 }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//test case one: 1>2>2>1
		ListNode one1 = new ListNode(1);
		ListNode one2 = new ListNode(2);
		ListNode one3 = new ListNode(2);
		ListNode one4 = new ListNode(1);
		
		one1.next = one2;
		one2.next = one3;
		one3.next = one4;
		one4.next = null;
		
		//test case two: 1>2
		ListNode two1 = new ListNode(1);
		ListNode two2 = new ListNode(2);
		
		two1.next = two2;
		two2.next = null;

		
		//run the test cases:
		//test 1
		System.out.println(isPalindrome(one1));
		
		//test 2
		System.out.println(isPalindrome(two1));
		

}
}
