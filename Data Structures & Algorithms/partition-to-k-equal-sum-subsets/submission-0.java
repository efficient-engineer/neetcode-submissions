class Solution {
    int requiredSum = 0;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int x : nums)
            sum += x;
        if (sum % k != 0)
            return false;

        this.requiredSum = sum/k;
        Arrays.sort(nums);
        swap(nums);

        boolean isVisited[] = new boolean[nums.length];

        return canPartitionKSubsets(0, nums, k, 0, isVisited);
    }

    private void swap(int[] nums) {
        int l = 0; int r = nums.length - 1;
        while (l <= r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++; r--;
        }
    }

    private boolean canPartitionKSubsets(int index, int[] nums, int k, int currentSubsetSum, boolean[] isVisited) {
        if(k == 0) return true;
        if(currentSubsetSum == requiredSum) {
           return canPartitionKSubsets(0, nums, k - 1, 0, isVisited);
        }

        for(int i = index; i < nums.length; i++) {
            if(currentSubsetSum + nums[i] > requiredSum || isVisited[i]) {
                continue;
            }

            isVisited[i] = true;
            boolean found = canPartitionKSubsets(index + 1, nums, k, currentSubsetSum + nums[i], isVisited);
            if(found) return true;
            isVisited[i] = false;
        }

        return false;
    }
}