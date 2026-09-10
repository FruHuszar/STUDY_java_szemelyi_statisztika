package main;

public class Szemely {
    private String nev;
    private int szulEv;

    public Szemely(String nev, int szulEv) {
        this.nev = nev;
        this.szulEv = szulEv;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzulEv() {
        return szulEv;
    }

    public void setSzulEv(int szulEv) {
        this.szulEv = szulEv;
    }
}