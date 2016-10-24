package com.farm.app.Pomocnicze;

/**
 * Created by slawekskel on 10/5/16.
 */
import java.util.Scanner;

public class GPTerms {
    public static void main(String[] arg)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter first term, common ratio and n (number of terms)");
        int a=sc.nextInt(),r=sc.nextInt(),n=sc.nextInt();

        System.out.print("\n"+a);
        for(int i=1;i<n;i++)
            System.out.print(" "+(a*=r));
    }
}

class Series
{
    public static void main(String args[])
    {
        int a,d,n=1,t,b;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first term of A.P");
        a=sc.nextInt();
        System.out.println("Enter difference");
        d=sc.nextInt();
        System.out.println("Enter the number of terms");
        b=sc.nextInt();

        while(b!=n-1)
        {
            t=(a+(n-1)*d);
            n++;
            System.out.print(t+" ");
        }
    }
}

class Fibonacci {

    public int fibonacciIteracja(int n) {
        int pierwszy = 1;
        int drugi = 1;
        int pomocnicza = 1;

        for(int i=2; i<n; i++) {
            pomocnicza = pierwszy + drugi;
            pierwszy = drugi;
            drugi = pomocnicza;
        }

        return pomocnicza;
    }

    public int fibonacciRekurencja(int n) {
        return n<2? n : fibonacciRekurencja(n - 1) + fibonacciRekurencja(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        int fiboIter, fiboRek = 0;

        fiboIter = fibo.fibonacciIteracja(6);
        fiboRek = fibo.fibonacciRekurencja(6);

        System.out.println("Iteracja: "+fiboIter);
        System.out.println("Rekurencja: "+fiboRek);
    }
}

class Rekurencja1 {

    public int sumaIteracja(int n) {
        int suma = 0;
        while(n > 0) {
            suma = suma+n;
            n--;
        }
        return suma;
    }

    public int sumaRekurencja(int n) {
        if(n>0) {
            return n + sumaRekurencja(n-1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Rekurencja1 r = new Rekurencja1();
        int iteracja, rekurencja = 0;

        iteracja = r.sumaIteracja(3);
        rekurencja = r.sumaRekurencja(3);

        System.out.println("Iteracja: "+iteracja);
        System.out.println("Rekurencja: "+rekurencja);
    }
}