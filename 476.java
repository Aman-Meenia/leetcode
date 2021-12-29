class Solution {
    public int findComplement(int num) {
        int temp = num;
        int dig = 0;
        while (temp != 0) {
            dig++;
            temp = temp / 2;
        }
        return num ^ (int)(Math.pow(2,dig) - 1);
    }
}
