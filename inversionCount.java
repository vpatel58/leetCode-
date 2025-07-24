class Solution {
    static int count;
    static int inversionCount(int arr[]) {
        // Code Here
        count = 0;
        mergeSort(arr, 0, arr.length - 1);
        return count;
    }
    
    public static int[] mergeSort(int arr[], int start, int end) {
        if (start == end) return new int[] {arr[start]};
        int mid = (start + end) / 2;
        int[] firstHalf = mergeSort(arr, start, mid);
        int[] secondHalf = mergeSort(arr, mid + 1, end);
        
        return merge(firstHalf, secondHalf);
    }
    
    public static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                res[k++] = a[i++];
            } else {
                res[k++] = b[j++];
                count = count + (a.length - i);
            }
        }
        while (i < a.length) res[k++] = a[i++];
        while (j < b.length) res[k++] = b[j++];
        return res;
    } 
}
