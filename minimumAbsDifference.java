class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff  = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            diff = Math.min(arr[i + 1] - arr[i], diff);
        }
        List<List<Integer>> result = new ArrayList<>();
    
        int i = 0, j = 1;
        while (j < arr.length) {
            if (arr[j] - arr[i] == diff) {
                result.add(Arrays.asList(arr[i], arr[j]));
                i++;
                j++;
            } else {
                i++;
                j++;
            }
        } 
        return result;
    }
}
