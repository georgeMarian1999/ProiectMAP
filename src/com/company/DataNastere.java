package com.company;

public class DataNastere {
    private int ziua;
    private int luna;
    private int varsta;

    public DataNastere(){
        ziua=0;
        varsta=0;
     }
    public DataNastere(int z,int l,int v){
        ziua=z;
        luna=l;
        varsta=v;
    }

    public int getZiua() {
        return ziua;
    }

    public int getLuna() {
        return luna;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setZiua(int ziua) {
        this.ziua = ziua;
    }

    public void setLuna(int luna) {
        this.luna = luna;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }
    public void afisare(){
        System.out.print(ziua+" "+luna+" "+varsta);
    }

    @Override
    public String toString() {
        String s;
        s=ziua+"-"+luna+"-"+varsta;
        return s;
    }
}
