class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> setOfnums = new HashSet<Integer>();

        for(int x : nums) {
            if(setOfnums.contains(x))
                return true;
            setOfnums.add(x);
        }

        return false;
    }
}