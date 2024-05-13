package dsa.with.shagun.leetcode.PFD24.TwoPointers;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        //we will iterate both numbers till we have values
        int i=0;
        int j=0;
        int len1 = version1.length();
        int len2 = version2.length();
        int temp1 = 0;
        int temp2 = 0;

        while(i < len1 || j < len2){
            temp1 = 0;
            temp2 = 0;

            //create first num from i
            while(i < len1 && version1.charAt(i) != '.'){
                 temp1 += temp1*10 + version1.charAt(i) - '0';
                 i++;
            }

            while(j < len2 && version2.charAt(j) != '.') {
                temp2 += temp2 * 10 + version2.charAt(j) - '0';
                j++;
            }
        }

        if(temp1 < temp2){
            return -1;
        }else if(temp1 > temp2){
            return 1;
        }else{
            return 0;
        }
    }
}
