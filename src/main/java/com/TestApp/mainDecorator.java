package com.farm.app.Pomocnicze;

/**
 * Created by slawekskel on 10/3/16.
 */
/****************************************
 *   Wzorzec Projektowy Decorator        *
 *   (dekorator )                        *
 *   www.algorytm.org                    *
 *   Opracowal Dworak Kamil              *
 *****************************************/

/* Standardowy nieudekorowany samochod */
interface Samochod {
    String samochod = "Samochod podstawowy";

    String about();
    double cena();
}

/* abstrakcyjny dekorator */
interface Dekorator extends Samochod {
}

/* teraz mamy 2 przykladowe marki samochodow */
class Mercedes implements Samochod {

    private String samochod;

    public Mercedes(){
        samochod = "Mercedes";
    }
    public String about(){
        return samochod;
    }

    public double cena(){
        return 500000;
    }
}

class Fiat implements Samochod {
    private String samochod;

    public Fiat(){
        samochod = "Fiat";
    }

    public String about(){
        return samochod;
    }

    public double cena(){
        return 100000;
    }
}

/* czas na same dodatki */
class Klimatyzacja implements Dekorator {
    Samochod samochod;

    public Klimatyzacja(Samochod samochod){
        this.samochod = samochod;
    }

    public String about(){
        return samochod.about() + " + klimatyzacja";
    }

    public double cena(){
        if(samochod instanceof Mercedes){
            return samochod.cena()+100000;
        }
        else if(samochod instanceof Fiat){
            return samochod.cena()+20000;
        }
        return 0.;
    }
}

class OponyZimowe implements Dekorator {
    Samochod samochod;

    public OponyZimowe(Samochod samochod){
        this.samochod = samochod;
    }

    public String about(){
        return samochod.about() + " + opony zimowe";
    }

    /* niech ceny beda takie same */
    public double cena(){
        return samochod.cena()+31234;
    }
}

public class mainDecorator {
    public static void main(String[]args){


        Samochod s1 = new Mercedes();
        Samochod s2 = new Fiat();

        System.out.println("\nBez wyposazenia");
        System.out.println(s1.about() + " " + s1.cena());
        System.out.println(s2.about() + " " + s2.cena());

//dodajemy po klimie

        s1 = new Klimatyzacja(s1);
        s2 = new Klimatyzacja(s2);
        System.out.println("\nZ Klima");
        System.out.println(s1.about() + " " + s1.cena());
        System.out.println(s2.about() + " " + s2.cena());

// i opony

        s1 = new OponyZimowe(s1);
        s2 = new OponyZimowe(s2);
        System.out.println("\nZ oponami");
        System.out.println(s1.about() + " " + s1.cena());
        System.out.println(s2.about() + " " + s2.cena());

//odrazu tworzymy wyposazony samochod
        System.out.println("\nPelne wyposazenie");
        Samochod s3 = new OponyZimowe(new Klimatyzacja(new Mercedes()));
        System.out.println(s3.about() + " " + s3.cena());
    }

}