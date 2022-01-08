class Solution {
    public int minDeletions(String s) {
        
        int freq[] = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        
        Arrays.sort(freq);
        
        Set<Integer> occupiedFrequencies = new HashSet<>();
        int requiredDeletions = 0;
        
        for (int i = 0; i < 26; i++) {
            int currFreq = freq[i];
            
            while (currFreq > 0) {
                if (occupiedFrequencies.contains(currFreq)) {
                    currFreq--;
                    requiredDeletions++;
                }
                else {
                    break;
                }
            }
            if (currFreq != 0) {
               occupiedFrequencies.add(currFreq); 
            }
        }
        
        return requiredDeletions;
    }
}
