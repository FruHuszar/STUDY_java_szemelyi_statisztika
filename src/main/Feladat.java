package main;

import java.util.Random;

public class Feladat {

    public static int ideiEv = 2026;
    public static int nyugdijKorhatar = 65;

    public static void main(String[] args) {
        feladat();
    }

    private static void feladat() {
        String nev = "Fru";
        int szulEv = 2003;

        int kor = eletkor(szulEv);
        int nyugdijEv = nyugdijEve(szulEv);

        ellenorzes(szulEv);

        koszontes();

        String adat = "Név: %s".formatted(nev);
        adat += "\nÉletkor (%d-ban): %d év".formatted(ideiEv, kor);
        adat += "\nNyugdíjazás éve (%d évesen): %d".formatted(nyugdijKorhatar, nyugdijEv);
        megjelenites(adat);
    }

    private static void koszontes(String nev) {
        System.out.println("Üdv, " + nev + "!");
    }

    // Túlterhelt metódus paraméter nélkül
    private static void koszontes() {
        String koszones = veletlenKoszontes();
        System.out.println(koszones);
    }

    private static String veletlenKoszontes() {
        String[] koszontesek = {"Szius!", "Hello!", "Hi!"};
        int index = veletlenIndex(koszontesek.length);
        return koszontesek[index];
    }

    private static int veletlenIndex(int max) {
        Random random = new Random();
        return random.nextInt(max);
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