//1 boats
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        Arrays.sort(people);
        int i=0,j=people.length-1;
        while(i<=j){
            if((people[j]+people[i])<=limit){
                i++;
            }
            j--;
            boats++;
        }
        return boats;
    }
}
//2 lemmonade change
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for(int i = 0; i < bills.length; ++i){
            if(bills[i] == 5){
                five += 1;
            } else if(bills[i] == 10){
                if(five == 0) return false;
                five -= 1;
                ten += 1;
            } else {
                if(!(five > 2) && !(five > 0 && ten > 0)) return false;

                if(five > 0 && ten > 0){
                    five -= 1;
                    ten -= 1;
                } else{
                    five -= 3;
                }
            }
        }
        return true;
    }
}
//3 non overapping intervals
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int res = 0;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int prev_end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prev_end > intervals[i][0]) {
                res++;
            } else {
                prev_end = intervals[i][1];
            }
        }

        return res;        
    }
}
//4 minium no of arrow to burst ballon
class Solution {
    public int findMinArrowShots(int[][] segments) {
        Arrays.sort(segments, (a, b) -> Integer.compare(a[1], b[1]));
        int ans = 0, arrow = 0;
        for (int i = 0; i < segments.length; i ++) {
            if (ans == 0 || segments[i][0] > arrow) {
                ans ++;
                arrow = segments[i][1];
            }
        }
        return ans;
    }
}
