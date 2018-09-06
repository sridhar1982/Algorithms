package arrayManipulations;

/**
 * pivot element is the minimum element in circular sorted array
 * eg:[5,6,1,2,3] -> pivot is 1 and piv index is 2
 * the property of pivot is the element prior and after to pivot is greater than pivot itself
 */
public class CircularSortedArrayMethods {

    public static void main(String[] args) {

        System.out.println("*****pivIdx *****");
        pivElement(new int[]{1,2,3,4,5});
        pivElement(new int[]{5,1,2,3,4});
        pivElement(new int[]{4,5,1,2,3});
        pivElement(new int[]{3,4,5,1,2});
        pivElement(new int[]{2,3,4,5,1});

        System.out.println("*****binary search*****");
        binarySearchCircularArray(new int[]{1,2,3,4,5},5);
        binarySearchCircularArray(new int[]{5,1,2,3,4},5);
        binarySearchCircularArray(new int[]{4,5,1,2,3},5);
        binarySearchCircularArray(new int[]{3,4,5,1,2},5);
        binarySearchCircularArray(new int[]{2,3,4,5,1},5);

        System.out.println("*****find sum pair *****");
        //findSumPair(new int[]{1,2,3,4,5},5);
        findSumPair(new int[]{5,1,2,3,4},5);
        findSumPair(new int[]{4,5,1,2,3},5);
        findSumPair(new int[]{3,4,5,1,2},5);
        findSumPair(new int[]{2,3,4,5,1},5);

    }

    public static int pivElement(int[] arr) {

        int left = 0;
        int right = arr.length-1;
        int n = arr.length;
        int pivIdx = -1;

        while (left<=right) {
            if (arr[left]<=arr[right]) {
                pivIdx = left;
                break;
            }

            int mid = (left+right)/2;
            int prev = (mid-1+ n)%n;
            int next = (mid+1)%n;
            if (arr[mid]<=arr[prev] && arr[mid]<=arr[next]){
                pivIdx=mid;
                break;
            }
            else if (arr[left] <= arr[mid]) {
                left=mid+1;
            }
            else {
                right=mid-1;
            }
        }
        System.out.println("pivot idx " + pivIdx + "; pivot el " + arr[pivIdx]);
        return pivIdx;
    }

    public static void binarySearchCircularArray(int[] arr, int val) {
        int left = 0;
        int right = arr.length-1;
        int n = arr.length;
        int foundIdx = -1;

        while (left<=right) {
            int mid = (left+right)/2;
            if (arr[mid]==val){
                foundIdx = mid;
                break;
            }
            else if (arr[mid]<=arr[right]) {
                if (arr[mid]<val && arr[right]>=val) {
                    left=mid+1;
                }
                else {
                    right=mid-1;
                }
            } else if (arr[left]<=arr[mid]) {
                if (arr[left]<=val && arr[mid] > val) {
                    right=mid-1;
                }
                else {
                    left=mid+1;
                }
            }
        }

        if (foundIdx==-1) {
            System.out.println("index not found");
            return;
        }
        System.out.println("found at index " + foundIdx);

    }

    public static void findSumPair(int[] arr, int sum) {
        int n = arr.length;

        int pivIdx = pivElement(arr);
        int left = pivIdx;
        int right = (pivIdx-1+n)%n;

        while (left!=right) {
            if (arr[left]+arr[right]==sum) {
                System.out.println("left index is " + left + "; right index is " + right);
                left = (left + 1)%n;
                right = (right-1+n)%n;
            }
            else if (arr[left]+arr[right]<sum) {
                left = (left + 1)%n;
            }
            else {
                right = (right-1+n)%n;
            }
        }
        System.out.println("--");
    }
}
