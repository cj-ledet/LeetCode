class Solution {
    
    private HashMap<Integer, Integer> memo = new HashMap<>();
    private int[] numbers;
    
    private int dp(int i) {
        //Base Cases
        if (i == 0) return numbers[0];
        if (i == 1) return Math.max(numbers[0], numbers[1]);    
        
        if (!memo.containsKey(i))
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + numbers[i]));
        return memo.get(i);
    }
    
    public int rob(int[] nums) {
        numbers = nums;
        return dp(numbers.length - 1);
    }
}