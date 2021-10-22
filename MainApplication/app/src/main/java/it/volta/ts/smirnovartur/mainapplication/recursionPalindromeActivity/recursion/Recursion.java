package it.volta.ts.smirnovartur.mainapplication.recursionPalindromeActivity.recursion;

public class Recursion {

    //---------Palindrome recursion---------
    public String recursionPalindrome(String str){
        if (str.length() == 1)
            return str;

        return recursionPalindrome(str.substring(1)) + str.charAt(0);
    }
}
