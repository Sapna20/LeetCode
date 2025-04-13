class Solution {
public:
    int majorityElement(vector<int>& nums) {
        
        sort(nums.begin(), nums.end());

        int max = 0;
        int curr_max = 0;
        int index = -1;

        for(int i=0; i<nums.size()-1; i++)
        {
            if(nums[i] == nums[i+1])
            {
                curr_max++;
                if(curr_max > max)
                {
                    max = curr_max;
                    index = i;
                }
            }
            else
            {
                curr_max = 0;
            }
        }
        return index == -1 ? nums[0] : nums[index];
    }
};