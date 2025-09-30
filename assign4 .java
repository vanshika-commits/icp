class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
       int l=0;
       int r=0;
       int max=0;
      
       int len=0;
       while(r<s.length()){
        if(!map.containsKey(s.charAt(r))){
            map.put(s.charAt(r),1);
            len++;
            r++;
            max=Math.max(max,len);
        }
        else{
            len=0;
            l++;
            r=l;
            map.clear();
        }
    
       }
       return max;
    }
}
//2
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;

        for (int n : nums) {
            if (n == 0) {
                count = 0;
            } else {
                count++;
            }

            if (res < count) {
                res = count;
            }
        }

        return res;        
    }
}
//3
class Solution {
    public int characterReplacement(String s, int k) {
     
        int[] arr = new int[26];
        int res = 0;
        int max = 0;

        
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
          
            arr[s.charAt(r) - 'A']++;

           
            max = Math.max(max, arr[s.charAt(r) - 'A']);

           
            if (r - l + 1 - max > k) { 
           
                arr[s.charAt(l) - 'A']--;
                l++;
            }

           
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
//4
import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()){
            return new ArrayList<>();
        }
        int[] freq = new int[26];
        for(int i = 0; i < p.length(); i++){
            freq[p.charAt(i) - 'a']++;
        }
        
        int[] comp = new int[26];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < p.length(); i++){
            comp[s.charAt(i) - 'a']++;
        }
        
        int left = 0;
        if(Arrays.equals(freq, comp)){
            list.add(left);
        }
        
        int right = p.length();
        while(right < s.length()){
            comp[s.charAt(right) - 'a']++;  
            comp[s.charAt(left) - 'a']--;  
            left++;                         
            right++;
            
            if(Arrays.equals(freq, comp)){
                list.add(left);
            }
        }
        
        return list;
    }
}
