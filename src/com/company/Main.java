package com.company;
/*Se crează o BD (sau ansamblu de fişiere/tabele în memorie) ce conţine informaţii complete despre salariaţii unei firme.
Se cere soft pentru operaţii CRUD (Create/Read/Update/Delete)şi pentru mai multe situaţii:
- fluturaşii cu venitul lunar (2 categorii de operaţii: ce se adaugă şi ce se retrage din salariul brut);
- tabel cu salariaţii ce au salar mai mic decât media salariilor pe firmă lei;
- tabel cu persoanele ce au implinit sau împlinesc vârsta pensionării în anul curent;
- tabel cu persoanele ce au de achitat rate lunare şi suma totală;
Deduceţi de ce clase aveţi nevoie!!!
*/
public class Main {

    public static void main(String[] args)throws Exception {
       // try{
        //UI U=new UI();
        //U.Run();
       // }
       // catch (Exception E){         System.out.println("Mesaj eroare");
         //   }
        GUI G=new GUI();
        G.afisaremeniu();
    }
}
