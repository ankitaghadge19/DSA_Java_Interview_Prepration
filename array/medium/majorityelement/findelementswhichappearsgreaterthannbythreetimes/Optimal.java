package array.medium.majorityelement.findelementswhichappearsgreaterthannbythreetimes;

import java.util.ArrayList;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 2, 1, 1, 3, 1, 4, 5, 6 };
        int n = nums.length;

        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = 0;
        int ele2 = 0;

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && ele2 != nums[i]) {
                ele1 = nums[i];
                cnt1 = 1;
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                ele2 = nums[i];
                cnt2 = 1;
            } else if (ele1 == nums[i]) {
                cnt1++;
            } else if (ele2 == nums[i]) {

                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == ele1) {
                cnt1++;
            }
            if (num == ele2) {
                cnt2++;
            }
        }
        if (cnt1 > n / 3) {
            result.add(ele1);
        }
        if (cnt2 > n / 3) {
            result.add(ele2);
        }
        System.out.println(result);
    }
}

// TC: O(N)
// SC: O(1)

// At most two numbers can occur more than n/3 times
// Cancel one occurrence of each candidate with one different element

// Intuition:
// - At most TWO elements can appear more than n/3 times.
// - Maintain two candidates (ele1, ele2) and their counts (cnt1, cnt2).
// - If the current element matches a candidate, increase its count.
// - If a candidate's count becomes 0, replace it with the current element.
// - Otherwise, decrement both counts (cancel three distinct elements).

// Eg.
// [ 2 1 1 3 1 4 5 6], n = 8, 8/3= 2
// Current    ele1     cnt1     ele2     cnt2
//             0        0        0        0
//    2        2        1        0        0
//    1        2        1        1        1
//    1        2        1        1        2
//    3        2        0        1        1  -> Cancel out 3 with one occurance of element 1 and 2
//    1        2        0        1        2
//    4        4        1        1        2
//    5        4        0        1        1  -> Cancel out 5 with one occurance of element 1 and 4
//    6        6        1        1        1

// After the first pass, the possible candidates are:
// ele1 = 6
// ele2 = 1

// The first pass only finds possiblr majority elements.
// A second pass is required to count their actual frequencies.

// Frequency:
// 6 -> 1 time
// 1 -> 3 times

// Since 3 > (8/3 = 2), the answer is:
// [1]

