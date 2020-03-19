package com.company;

import java.util.Scanner;

public class UI {
    private CTRL C;

    public UI(){
        C=new CTRL();
    }
    public void meniu1(){
        System.out.println("Bine ati venit!");
        System.out.println("Va rog sa alegeti o optiune:");
        System.out.println("1.Porneste aplicatia");
        System.out.println("2.Iesire");
        System.out.print("Dati optiunea: ");
    }
    public void meniu2(){
        System.out.println("Va rog sa alegeti o optiune:");
        System.out.println("1.Adauga un angajat");
        System.out.println("2.Update informatii ale unui angajat");
        System.out.println("3.Sterge un angajat");
        System.out.println("4.Afiseaza salariatii care au salar net mai mic decat media salariilor pe firma");
        System.out.println("5.Afiseaza ce se retrage din salarul brut al fiecarui angajat");
        System.out.println("6.Afiseaza ce se adauga la salarul brut al fiecarui angajat");
        System.out.println("7.Afiseaza salariatii care au implinit sau vor implini varsta de pensionare ");
        System.out.println("8.Afiseaza suma totala a ratelor angajatilor din firma si angajatii care au de platit rate");
        System.out.println("9.Afiseaza toti angajatii");
        System.out.println("10.Revenire");
        System.out.print("Dati optiunea: ");
    }
    public void scurt(){
        System.out.println("Care angajat doriti sa il stergeti?");
        C.afisarescurta();
    }
    public void scurtupdate(){
        System.out.println("Care angajat doriti sa il modificati?");
        C.afisarescurta();
    }
    public void Run(){
        try{
            C=new CTRL();
        int op1,op2;
        meniu1();
        Scanner scr=new Scanner(System.in);
        op1=scr.nextInt();
        while(op1==1){
            C.citire();
            meniu2();
            op2=scr.nextInt();
            while(op2>0&&op2<10){
                if(op2==1){
                    Salariat S=new Salariat();
                    S.citire();
                    C.Add(S);
                    C.scrie();
                }
                if(op2==2){
                    scurtupdate();
                    int op4=scr.nextInt();
                    System.out.println("Dati valori noi");
                    Salariat S=new Salariat();
                    S.citire();
                    C.update(op4-1,S);
                    System.out.println("Update efectuat cu succes!");
                    C.scrie();
                }
                if(op2==3){
                    scurt();
                    int op3=scr.nextInt();
                    C.Del(op3-1);
                    System.out.println("Stergere efectuata cu succes!");
                    C.scrie();
                }
                if(op2==4){
                    C.afisaremedia();
                }
                if(op2==5){
                    C.afisarededucti();
                }
                if(op2==6){
                    C.afisareprime();
                }
                if(op2==7){
                    C.afisareSalPens();
                }
                if(op2==8){
                    C.afisareRate();
                }
                if(op2==9){
                    C.afisare();
                }
                meniu2();
                op2=scr.nextInt();
            }
            meniu1();
            op1=scr.nextInt();

        }
        System.out.println("La revedere!");
        }catch (Exception E){
            System.out.println("Ceva eroare");
        }
    }
}
