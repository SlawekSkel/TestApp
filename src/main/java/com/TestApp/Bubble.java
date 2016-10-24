package com.farm.app.Pomocnicze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by slawekskel on 10/6/16.
 */
class Bubble
{
    private static int[] tablica;
    private static int[] tablica2;

    public static void main(String[] args) throws java.io.IOException
    {
        System.out.println("Wpisz liczby które chcesz posortować oddzielone spacją:");

        BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer liczby = new StringTokenizer(reader.readLine());

// wstaw liczby do tablicy
        tablica = new int[liczby.countTokens()];
        tablica2 = new int[liczby.countTokens()];
        int temp;
        for (int i=0;i<tablica.length;i++) {

            temp = Integer.parseInt(liczby.nextToken());
            tablica[i] = temp;
            tablica2[i] = temp;

        }

        b_sort(tablica); // sortuj
        b_sort2(tablica2);


// wyswietl posortowae liczby
        System.out.println("Posortowane liczby1:");
        for (int liczba:tablica)
            System.out.print(liczba+" ");

        System.out.println("");

        System.out.println("Posortowane liczby2:");
        for (int liczba:tablica2)
            System.out.print(liczba+" ");
    }

    public static void b_sort(int[] tablica)
    {
        int mniejszaLiczba = tablica.length-1; // indeks pierwszej porownywanej liczby; wartosc poczatkowa
        int wiekszaLiczba = mniejszaLiczba-1; // indeks drugiej porownywanej liczby; wartosc poczatkowa


        int tmp;
        while (wiekszaLiczba >= 0) // indeks drugiej porownywanej liczby musi byc nie mniejszy niz zero
        {
            if (tablica[wiekszaLiczba] > tablica[mniejszaLiczba]) // jesli druga liczba jest wieksza niz pierwsza
            {
                tmp = tablica[wiekszaLiczba];
                tablica[wiekszaLiczba] = tablica[mniejszaLiczba]; // zamien wartosci
                tablica[mniejszaLiczba] = tmp;

                mniejszaLiczba = tablica.length-1;  // zresetuj licznik
                wiekszaLiczba = mniejszaLiczba-1;   // zresetuj licznik
            }
            else // jesli druga liczba jest mniejsza lub rowna pierwszej, zmniejsz licznik o 1
            {
                mniejszaLiczba--;
                wiekszaLiczba--;
            }
        }
    }

    public static void b_sort2(int[] tablica)
    {

        int mniejszaLiczba;
        boolean sorted = true;

        for (int j = tablica.length-1; j > 0; j--) {

            for (int i = 0; i < j; i++) {

                if (tablica[i] > tablica[i + 1]) {

                    mniejszaLiczba = tablica[i + 1];
                    tablica[i + 1] = tablica[i];
                    tablica[i] = mniejszaLiczba;

                    sorted = false;
                }
                if (i == j-1) {

                    if (sorted == true) {
                        j = 0;
                    }else {
                        sorted= true;
                    }

                }

            }
        }

    }
}

