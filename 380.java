class RandomizedSet {

    private int counter;
    private Map<Integer, Integer> indToVal;
    private Map<Integer, Integer> valToInd;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.counter = 0;
        this.indToVal = new HashMap<>();
        this.valToInd = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToInd.containsKey(val)) {
            return false;
        }
        indToVal.put(counter, val);
        valToInd.put(val, counter++);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToInd.containsKey(val)) {
            return false;
        }
        
        int ind = valToInd.get(val);
        indToVal.remove(ind);
        valToInd.remove(val);
        if (ind == counter - 1) {
            counter--;
        }
        else {
            int maxIndVal = indToVal.get(counter - 1);
            valToInd.put(maxIndVal, ind);
            indToVal.put(ind, maxIndVal);
            indToVal.remove(counter - 1);
            counter--;
        }
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int ind = random.nextInt(counter);
        return indToVal.get(ind);
    }
}
