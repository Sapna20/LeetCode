class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> keys = new HashSet<Integer>();

        for(int x : nums) {
            if(keys.contains(x)) 
                return true;
            else 
                keys.add(x);
        }

        return false;
    }
}