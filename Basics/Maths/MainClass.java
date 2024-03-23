package Basics.Maths;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public void reverseANumber(int num){
        int tempNum = num;
        int reverseNum = 0;

        while(tempNum > 0){
            int digit = tempNum % 10;
            reverseNum = reverseNum * 10 + digit;
            tempNum = tempNum / 10;
        }

        System.out.println(reverseNum);
    }

    public void countDigits(int num){
        int count = 0;
        int tempNum = num;
        while(tempNum > 0){
            int digit = tempNum % 10;
            System.out.println(digit);
            tempNum = tempNum / 10;
            count += 1;
        }
        System.out.println("COUNT : " + count);
    }

    /*
        Time : O(sqrt(N))
        Space : O(N)
    */
    public void printAllDivisors(int num){
        List<Integer> divisors = new ArrayList<>();

        for(int i = 1;i <= Math.sqrt(num);i++){
            if((num % i) == 0){
                divisors.add(i);
                if((num/i) != i){
                    divisors.add(num/i);
                }
            }
        }

        System.out.println(divisors);
    }

    /*
        base of log is phi, because no of steps this algo takes resembles fibonacci sequence
        and growth rate of fibonacci seq is governed by golden ratio phi = 1.61.....

        Time : O( log_ϕ( min(a,b) ) )
        Space : O(1)
    */
    public void greatestCommonDivisor(int a,int b){

        while(a > 0 && b > 0){
            if(a > b){
                a = a % b;
            }else{
                b = b % a;
            }
        }

        if(a == 0){
            System.out.println(b);
        }
        if(b == 0){
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        MainClass mainClass = new MainClass();
//        mainClass.reverseANumber(1234567);
//        mainClass.countDigits(1234545);
//        mainClass.printAllDivisors(12348);
        mainClass.greatestCommonDivisor(126,124578);
    }
}
