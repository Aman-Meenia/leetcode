class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> window = new LinkedList<Integer>();
        int solution[] = new int[nums.length - k + 1];
        int index = 0;
        
        window.addFirst(0);
        
        for (int itr = 1; itr < k; itr++) {
            while (window.size() > 0 && nums[itr] > nums[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(itr);
        }
        solution[index++] = nums[window.peekFirst()];
        
        for (int itr = k; itr < nums.length; itr++) {
            if (window.peekFirst() < (itr - k + 1)) {
                window.removeFirst();
            }
            
            while (window.size() > 0 && nums[itr] > nums[window.peekLast()]) {
                window.removeLast();
            }
            window.addLast(itr);
            solution[index++] = nums[window.peekFirst()];
        }
        
        return solution;
    }
}
