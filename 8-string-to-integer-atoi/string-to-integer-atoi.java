class Solution {
    public int myAtoi(String s) {
        int i=0;
        int n = s.length();

        while(i<n && s.charAt(i)==' '){
            i++;
        }

        int sign =1;
        if(i<n && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            if(s.charAt(i)=='-') sign=-1;
            i++;
        }

        int num =0;
        while(i<n && Character.isDigit(s.charAt(i))){
            int digit = s.charAt(i)-'0';
            if (num > Integer.MAX_VALUE / 10) {
    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
}

if (num == Integer.MAX_VALUE / 10) {
    if (sign == 1 && digit > 7) return Integer.MAX_VALUE;
    if (sign == -1 && digit > 8) return Integer.MIN_VALUE;
    if (sign == -1 && digit == 8) return Integer.MIN_VALUE; // ⭐ key line
}

num = num * 10 + digit;

            i++;
        }
        return num*sign;
    }
}