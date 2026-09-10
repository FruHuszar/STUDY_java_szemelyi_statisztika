package main;

import java.util.Random;

public class Statisztika {

    public static int ideiEv = 2026;
    public static int nyugdijKorhatar = 65;
    public static final Random RND = new Random();

    public static void main(String[] args) {
        feladat();
    }

    private static void feladat() {
        // A Statisztika osztály példányosítja a Személyt:
        Szemely szemely = new Szemely("Fru", 2003);

        int kor = eletkor(szemely.getSzulEv());
        int nyugdijEv = nyugdijEve(szemely.getSzulEv());

        ellenorzes(szemely.getSzulEv());

        koszontes(szemely.getNev());

        String adat = "Név: %s".formatted(szemely.getNev());
        adat += "\nÉletkor (%d-ban): %d év".formatted(ideiEv, kor);
        adat += "\nNyugdíjazás éve (%d évesen): %d".formatted(nyugdijKorhatar, nyugdijEv);
        megjelenites(adat);
    }

    private static void koszontes(String nev) {
        koszontes(nev, true);
    }

    private static void koszontes(String nev, boolean veletlen) {
        String megszolitás = veletlen ? veletlenKoszontes() : "Üdv";
        System.out.println(megszolitás + ", " + nev + "!");
    }

    private static String veletlenKoszontes() {
        String[] koszontesek = {"Szius", "Hello", "Hi"};
        int index = veletlenIndex(koszontesek.length);
        return koszontesek[index];
    }

    private static int veletlenIndex(int max) {
        return RND.nextInt(max);
    }

    private static int eletkor(int szulEv) {
        return ideiEv - szulEv;
    }

    private static int nyugdijEve(int szulEv) {
        return szulEv + nyugdijKorhatar;
    }

    private static void megjelenites(String adat) {
        System.out.println(adat);
    }

    private static void ellenorzes(int szulEv) {
        if (!helyesSzulEvE(szulEv)) {
            System.err.println("Hiba: A születési év nem lehet a jövőben vagy reálisan túl régen!");
            throw new IllegalArgumentException("Érvénytelen születési év.");
        }
    } 

    private static boolean helyesSzulEvE(int szulEv) {
        return szulEv > 1900 && szulEv <= ideiEv;
    }
}