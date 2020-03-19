package com.company;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Salariat {
    private String ID_Salariat;
    private String nume;
    private DataNastere D;
    private Venit salariu;
    private long ratalunara;

    public Salariat(){
        D=new DataNastere();
        salariu=new Venit();
        ratalunara=0;
    }
    public Salariat(String ID,String n,DataNastere Data,long s,long r){
        ID_Salariat=ID;
        nume=n;
        D=Data;
        if(r!=0)
            s=s+r/2;
        salariu=new Venit(s);
        ratalunara=r;
    }
    public Salariat(Salariat S){
        if(this!=S){
            ID_Salariat=S.ID_Salariat;
            nume=S.nume;
            D=S.D;
            salariu=S.salariu;
            ratalunara=S.ratalunara;
        }
    }
    public String getNume() {
        return nume;
    }

    public String getID_Salariat() {
        return ID_Salariat;
    }
    public int citireint(){
        try{
            Scanner scr=new Scanner(System.in);
            int l=scr.nextInt();
            return l;
        }
        catch(Exception e){
            System.out.println("Nu este numar intreg");
            return citireint();
        }
    }
    public long citirelong(){
        try{
            Scanner scr=new Scanner(System.in);
            long l=scr.nextLong();
            return l;
        }
        catch(Exception e){
            System.out.println("Nu este numar intreg");
            return citireint();
        }
    }
    public static String citirestring(String sir) throws IOException{
        char c;
        String s=new String();
        System.out.print(sir);
        do{
            c=(char) System.in.read();
            s=s+c;
        }
        while(c!='\n');
        return s.substring(0,s.length()-1);
    }
    public Venit getSalariubrut() {
        return salariu;
    }
    public void citire()throws IOException{
        String ID,nume;
        long rata,salar;
        int ziua,luna,ani;
        ID=citirestring("Dati ID-ul angajatului: ");
        System.out.println();
        nume=citirestring("Dati numele angajatului: ");
        System.out.println();
        System.out.print("Dati ziua nasterii: ");
        ziua=citireint();
        System.out.println();
        System.out.print("Dati luna nasterii: ");
        luna=citireint();
        System.out.println();
        System.out.print("Dati varsta salariatului: ");
        ani=citireint();
        System.out.println();
        DataNastere D=new DataNastere(ziua,luna,ani);
        System.out.print("Dati salariul brut :");
        salar=citirelong();
        System.out.println();
        System.out.print("Dati valoarea ratei lunare: ");
        rata=citirelong();
        System.out.println();
        Venit V=new Venit(salar);
        this.setID_Salariat(ID);
        this.setD(D);
        this.setNume(nume);
        this.setRatalunara(rata);
        this.setSalariu(V);


    }
    public int getziua(){
        return D.getZiua();
    }
    public int getluna(){
        return D.getLuna();
    }
    public int getvarsta(){
        return D.getVarsta();
    }
    public long getRatalunara() {
        return ratalunara;
    }
    public long getSalarNet(){
        return salariu.getSalarnet();
    }
    public long getConPensie(){
        return salariu.getConpensie();
    }
    public long getConSanatate(){
        return salariu.getConsanatate();
    }
    public long getImpozit(){
        return salariu.getImpozit();
    }
    public void setID_Salariat(String ID_Salariat) {
        this.ID_Salariat = ID_Salariat;
    }

    public void setD(DataNastere d) {
        D = d;
    }

    public Venit getSalariu() {
        return salariu;
    }

    public DataNastere getD() {
        return D;
    }

    public void setSalariu(Venit salariu) {
        this.salariu = salariu;
    }
    public void afisarescurta(){
        System.out.println(ID_Salariat+" "+nume);
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setSalariubrut(long salariub) {
        salariu=new Venit(salariub);
    }
    public void setRatalunara(long ratalunara) {
        this.ratalunara = ratalunara;
    }
    public void afisare(){
        System.out.println(ID_Salariat+" "+nume+" "+D.toString()+" "+salariu+" "+ratalunara);
    }
    public boolean pensionare(){
        LocalDate Data=LocalDate.now();
        if(D.getVarsta()<64)
            return false;
        if(D.getVarsta()>=65)
            return true;
        else {
            if(Data.getMonthValue()<D.getLuna())
                return true;
            else if(Data.getMonthValue()>D.getLuna())
                return false;
                else {
                    if(Data.getDayOfMonth()<D.getZiua())
                        return true;
                    else return false;
            }
        }
    }
}
