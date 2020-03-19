package com.company;

public class Venit {
    private long salarbrut;
    private long conpensie;
    private long consanatate;
    private long impozit;
    private long salarnet;

    public Venit() {
        salarbrut = 0;
        conpensie = 0;
        consanatate = 0;
        impozit = 0;
        salarnet = 0;
    }

    public Venit(long salar) {
        salarbrut = salar;
        conpensie = (25 * salar) / 100;
        consanatate = (10 * salar) / 100;
        impozit = (59 * salar) / 1000;
        salarnet = salar - (conpensie + consanatate + impozit);
    }

    public Venit(long s, long c1, long c2, long i, long sn) {
        salarbrut = s;
        conpensie = c1;
        consanatate = c2;
        impozit = i;
        salarnet = sn;
    }

    public long getSalarbrut() {
        return salarbrut;
    }

    public long getConpensie() {
        return conpensie;
    }

    public long getConsanatate() {
        return consanatate;
    }

    public long getImpozit() {
        return impozit;
    }

    public long getSalarnet() {
        return salarnet;
    }

    public void setSalarbrut(long salarbrut) {
        this.salarbrut = salarbrut;
    }

    public void setConpensie(long conpensie) {
        this.conpensie = conpensie;
    }

    public void setConsanatate(long consanatate) {
        this.consanatate = consanatate;
    }

    public void setImpozit(long impozit) {
        this.impozit = impozit;
    }

    public void setSalarnet(long salarnet) {
        this.salarnet = salarnet;
    }
    public void afisare(){
        System.out.println(salarbrut);
        System.out.println(conpensie);
        System.out.println(consanatate);
        System.out.println(impozit);
        System.out.println(salarnet);
        System.out.println();
    }
    @Override
    public String toString() {
        String s;
        s=this.salarnet+" ";
        return s;
    }
}
