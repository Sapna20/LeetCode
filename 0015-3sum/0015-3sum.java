class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for(int i=0; i<n; i++) {
            if(i > 0) {
                while( i<n && nums[i-1] == nums[i]) {
                    i++;
                }
                if(i >= n)
                    break;
            }
                int x = nums[i];
                int L = i+1;
                int R = n-1;

                while( L < R ) {
                    int y = nums[L];
                    int z = nums[R];
                    int sum = x + y + z;
                    if(sum == 0) {
                        List<Integer> ls = new ArrayList<Integer>();
                        ls.add(x);
                        ls.add(y);
                        ls.add(z);
                        ans.add(ls);
                        L++;
                        while(L<n && nums[L-1] == nums[L]){
                            L++;
                        }
                    } else if(sum > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
        }

        return ans;
    }
}