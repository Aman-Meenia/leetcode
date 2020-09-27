class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        int weightSum = 0;
        int maxWeight = 0;
        
        for (int ind = 0; ind < weights.length; ind++) {
            weightSum = weightSum + weights[ind];
            maxWeight = Math.max(weights[ind], maxWeight);
        }
        
        int min = maxWeight;
        int max = weightSum;
        int mid = min;
        
        while (min < max) {
            mid = min + (max - min) / 2;
            int day = 1;
            int sum = 0;
            for (int weight : weights) {
                if (sum + weight > mid) {
                    day++;
                    sum = weight;
                }
                else {
                    sum = sum + weight;
                }
            }
            if (day <= D) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        
        return min;
    }
}
