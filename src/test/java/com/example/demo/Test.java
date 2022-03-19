package com.example.demo;

public class Test {

    public static void main(String[] arg){
        System.out.println(ispar("i.like.this.program.very.much"));
    }

    static String ispar(String s)
    {
        // add your code here
        String[] arr = s.split("\\.");
        String sb = "";
        for(String str: arr){
            sb = str + "." + sb;
        }

        return sb.substring(0,sb.length()-1);
    }
}
