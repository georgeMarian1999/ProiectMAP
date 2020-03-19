package com.company;

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.text.LabelView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Vector;

public class Firma {
    private Vector<Salariat> Baza;

    public Firma(){
        Baza=new Vector<>();
    }
    public Vector<Salariat> getBaza() {
        return Baza;
    }
    public Salariat getSalariatpos(int i){
        return Baza.elementAt(i);
    }
    public void setBaza(Vector<Salariat> baza) {
        Baza = baza;
    }
    public void AddSalariat(Salariat S){
        Baza.add(S);
    }
    public void DelSalariat(int i){
        Baza.removeElementAt(i);
    }
    public void update(int i,Salariat S){
        Baza.setElementAt(S,i);
    }
    public long mediasal(){
        long s=0;
        for(int i=0;i<Baza.size();i++)
            s=s+Baza.elementAt(i).getSalarNet();
        s=s/Baza.size();
        return s;
    }
    public long sumarate(){
        long s=0;
        for(int i=0;i<Baza.size();i++)
            s=s+Baza.elementAt(i).getRatalunara();
        return s;
    }
    public void read()throws Exception{
        File F=new File("/Users/mariangeorge/IdeaProjects/ProiectMAP/src/com/company/bazadate.txt");
        BufferedReader br=new BufferedReader(new FileReader(F));
        String s=br.readLine();
        int size=Integer.parseInt(s);
        String line;
        String ID,nume;
        int varsta,ziua,luna;
        long salariu,rata;
        for(int i=0;i<size;i++){
            line=br.readLine();
            ID=line.split(",")[0];
            nume=line.split(",")[1];
            ziua=Integer.parseInt(line.split(",")[2]);
            luna=Integer.parseInt(line.split(",")[3]);
            varsta=Integer.parseInt(line.split(",")[4]);
            salariu=Integer.parseInt(line.split(",")[5]);
            rata=Integer.parseInt(line.split(",")[6]);
            DataNastere D=new DataNastere(ziua,luna,varsta);
            Salariat N=new Salariat(ID,nume,D,salariu,rata);
            Baza.add(N);
        }

        System.out.println("Citirea a bazei de date efectuata cu succes");
    }
    public void afisarelistaang(){
        for(int i=0;i<Baza.size();i++)
        {
            System.out.print(i+1);
            System.out.print(".");
            System.out.print(Baza.elementAt(i).getID_Salariat());
            System.out.print(" ");
            System.out.println(Baza.elementAt(i).getNume());
        }
    }
    public void write() throws IOException{
        FileWriter F=new FileWriter("/Users/mariangeorge/IdeaProjects/ProiectMAP/src/com/company/bazadate.txt");
        String aux;
        BufferedWriter writer = new BufferedWriter(F);
        aux=Integer.toString(Baza.size());
        writer.write(aux);
        writer.write('\n');
        for(int i=0;i<Baza.size();i++){
            writer.write(Baza.elementAt(i).getID_Salariat());
            writer.write(',');
            writer.write(Baza.elementAt(i).getNume());
            writer.write(',');
            aux=Integer.toString(Baza.elementAt(i).getziua());
            writer.write(aux);
            writer.write(',');
            aux=Integer.toString(Baza.elementAt(i).getluna());
            writer.write(aux);
            writer.write(',');
            aux=Integer.toString(Baza.elementAt(i).getvarsta());
            writer.write(aux);
            writer.write(',');
            aux=Long.toString(Baza.elementAt(i).getSalariubrut().getSalarbrut()-(Baza.elementAt(i).getRatalunara())/2);
            writer.write(aux);
            writer.write(',');
            aux=Long.toString(Baza.elementAt(i).getRatalunara());
            writer.write(aux);
            writer.write('\n');
        }
        writer.close();
    }
    public void afisareSalPens(){
        System.out.println("Salariatii care au implinit varsta de pensionare sau vor implinii anul asta sunt: ");
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).pensionare()==true)
                Baza.elementAt(i).afisarescurta();
    }
    public void afisaremedia(){
        long m=this.mediasal();
        System.out.println("Salariatii care au salar mai mic decat media salariilor pe firma sunt: ");
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).getSalarNet()<m)
                Baza.elementAt(i).afisarescurta();

    }
    public void afisareRate(){
        long r=this.sumarate();
        System.out.println("Persoanele care au de achitat rate sunt : ");
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).getRatalunara()!=0)
                Baza.elementAt(i).afisarescurta();
        System.out.println("Suma totala a ratelor in firma este: ");
        System.out.print(r);
        System.out.println();

    }
    public void afisaredeductii(){
        System.out.println("Deductiile pentru fiecare angajat sunt: ");
        for(int i=0;i<Baza.size();i++)
        {
            System.out.println("Pentru angajatul "+Baza.elementAt(i).getNume()+" din salar se deduce :");
            System.out.print("Contributie pensii: ");
            System.out.println(Baza.elementAt(i).getConPensie());
            System.out.print("Contributie sanatate: ");
            System.out.println(Baza.elementAt(i).getConSanatate());
            System.out.print("Impozit: ");
            System.out.println(Baza.elementAt(i).getImpozit());
        }
    }
    public void afisareprime(){
        System.out.println("Angajatii care primesc prima sunt: ");
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).getRatalunara()!=0){
                System.out.print("Pentru angajatul "+Baza.elementAt(i).getNume()+" la salar se adauga o prima de :");
                System.out.println(Baza.elementAt(i).getRatalunara()/2);
            }

    }
    public void afisare(){
        System.out.print("ID");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");

        System.out.print("Nume");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("Data");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("Salar");
        System.out.print(" ");
        System.out.print(" ");
        System.out.print("Rata lunara");
        System.out.print("\n");
        for(int i=0;i<Baza.size();i++)
            Baza.elementAt(i).afisare();
    }
    public JTable crearetabel(Vector<Vector<String>> Data,Vector<String> Column){
        final JTable Tabel=new JTable(Data,Column);
        Tabel.setBounds(0,40,500,20+20*Baza.size());
        Tabel.setFillsViewportHeight(true);
        return Tabel;
    }
    public Vector<String> createcolumn(String data[]){
        Vector<String> column=new Vector<>();
        for(int i=0;i<data.length;i++)
            column.add(data[i]);
        return column;
    }
    public Vector<Vector<String>> createData(Vector<Vector<String>> V,Vector<String> col){
        Vector<Vector<String>> data=new Vector<>();
        data.add(col);
        for(int i=0;i<V.size();i++)
            data.add(V.elementAt(i));
        return data;
    }
    public void adaugareGUI(){
        JFrame Submeniu1=new JFrame();
        Label Add=new Label("Va rog introduceti datele noului angajat!");
        Add.setBounds(100,50,300,20);
        TextField T1=new TextField();
        Label ID=new Label("ID:");
        ID.setBounds(100,130,60,20);
        T1.setBounds(150,130,200,20);
        TextField T2=new TextField();
        Label Nume=new Label("Nume:");
        Nume.setBounds(100,150,60,20);
        T2.setBounds(150,150,200,20);
        TextField T3=new TextField();
        Label Ziua=new Label("Ziua:");
        Ziua.setBounds(100,170,60,20);
        T3.setBounds(150,170,200,20);
        TextField T4=new TextField();
        Label Luna=new Label("Luna:");
        Luna.setBounds(100,190,60,20);
        T4.setBounds(150,190,200,20);
        TextField T5=new TextField();
        T5.setBounds(150,210,200,20);
        Label Varsta=new Label("Varsta:");
        Varsta.setBounds(100,210,60,20);
        TextField T6=new TextField();
        T6.setBounds(150,230,200,20);
        Label Salar=new Label("Salar");
        Salar.setBounds(100,230,60,20);
        TextField T7=new TextField();
        Label Rata=new Label("Rata:");
        Rata.setBounds(100,250,60,20);
        T7.setBounds(150,250,200,20);

        JButton Submit=new JButton("Submit");
        Submit.setBounds(150,300,200,50);
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ziua,luna,varsta;
                long rata,salar;
                String ID,nume;
                ID=T1.getText();
                nume=T2.getText();
                ziua=Integer.parseInt(T3.getText());
                luna=Integer.parseInt(T4.getText());
                varsta=Integer.parseInt(T5.getText());
                salar=Long.parseLong(T6.getText());
                rata=Long.parseLong(T7.getText());

                DataNastere D=new DataNastere(ziua,luna,varsta);
                Salariat S=new Salariat(ID,nume,D,salar,rata);
                AddSalariat(S);
                Label Succes=new Label("Angajat adaugat!");
                Succes.setBounds(150,400,200,20);
                Submeniu1.add(Succes);
                try{
                    write();}
                catch (Exception E){
                    System.out.println("Eroare scriere");
                }
            }
        });
        JButton Revenire=new JButton("Revenire");
        Revenire.setBounds(150,350,200,50);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Submeniu1.dispose();
            }
        });

        Submeniu1.add(Add);
        Submeniu1.add(T1);
        Submeniu1.add(ID);
        Submeniu1.add(T2);
        Submeniu1.add(Nume);
        Submeniu1.add(T3);
        Submeniu1.add(Ziua);
        Submeniu1.add(T4);
        Submeniu1.add(Luna);
        Submeniu1.add(T5);
        Submeniu1.add(Varsta);
        Submeniu1.add(T6);
        Submeniu1.add(Salar);
        Submeniu1.add(T7);
        Submeniu1.add(Rata);
        Submeniu1.add(Submit);
        Submeniu1.add(Revenire);

        Submeniu1.setSize(500,1000);
        Submeniu1.setLayout(null);
        Submeniu1.setVisible(true);
    }
    public void afisarebazadatGUI(){
        JFrame baza=new JFrame();
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Ziua-Luna-Var","Venit","Rata lunara"});
        for(int i=0;i<Baza.size();i++){
            Vector<String> Data3=new Vector<>();
            Data3.add(Baza.get(i).getID_Salariat());
            Data3.add(Baza.get(i).getNume());
            Data3.add(Baza.get(i).getD().toString());
            Data3.add(Baza.get(i).getSalariu().toString());
            Data3.add(Long.toString(Baza.get(i).getRatalunara()));
            Data1.add(Data3);
        }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void afisaredeductiiGUI(){
        JFrame baza=new JFrame();
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Contr. pensii","Contr. sanatate","Impozit"});
        for(int i=0;i<Baza.size();i++){
            Vector<String> Data3=new Vector<>();
            Data3.add(Baza.get(i).getID_Salariat());
            Data3.add(Baza.get(i).getNume());
            Data3.add(Long.toString(Baza.get(i).getConPensie()));
            Data3.add(Long.toString(Baza.get(i).getConSanatate()));
            Data3.add(Long.toString(Baza.get(i).getImpozit()));
            Data1.add(Data3);
        }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void afisareadaousGUI(){
        JFrame baza=new JFrame();
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Prima"});
        for(int i=0;i<Baza.size();i++){
            Vector<String> Data3=new Vector<>();
            Data3.add(Baza.get(i).getID_Salariat());
            Data3.add(Baza.get(i).getNume());
            Data3.add(Long.toString(Baza.get(i).getRatalunara()/2));
            Data1.add(Data3);
        }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void afisaremaimiccamediaGUI(){
        JFrame baza=new JFrame();
        long m=this.mediasal();
        Label Media=new Label("Media salariilor pe firma:"+Long.toString(m));
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Venit"});
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).getSalarNet()<m)
            {
                Vector<String> Data3=new Vector<>();
                Data3.add(Baza.get(i).getID_Salariat());
                Data3.add(Baza.get(i).getNume());
                Data3.add(Baza.get(i).getSalariu().toString());
                Data1.add(Data3);
            }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Media.setBounds(130,250,200,40);
        baza.add(Media);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void afisarerataGUI(){
        JFrame baza=new JFrame();
        long m=this.sumarate();
        Label Rata=new Label("Suma ratelor:"+Long.toString(m));
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Rata"});
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).getRatalunara()!=0)
            {
                Vector<String> Data3=new Vector<>();
                Data3.add(Baza.get(i).getID_Salariat());
                Data3.add(Baza.get(i).getNume());
                Data3.add(Long.toString(Baza.get(i).getRatalunara()));
                Data1.add(Data3);
            }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Rata.setBounds(130,250,200,40);
        baza.add(Rata);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void afisarepensGUI(){
        JFrame baza=new JFrame();
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Ziua-Luna-Var"});
        for(int i=0;i<Baza.size();i++)
            if(Baza.elementAt(i).pensionare())
            {
                Vector<String> Data3=new Vector<>();
                Data3.add(Baza.get(i).getID_Salariat());
                Data3.add(Baza.get(i).getNume());
                Data3.add(Baza.get(i).getD().toString());
                Data1.add(Data3);
            }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,300,200,40);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                baza.dispose();
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);
    }
    public void stergeGUI(){
        JFrame Sterge=new JFrame();
        int amount=1;
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Ziua-Luna-Var","Venit","Rata lunara"});
        for(int i=0;i<Baza.size();i++){
            Vector<String> Data3=new Vector<>();
            Data3.add(Integer.toString(amount));
            amount++;
            Data3.add(Baza.get(i).getNume());
            Data3.add(Baza.get(i).getD().toString());
            Data3.add(Baza.get(i).getSalariu().toString());
            Data3.add(Long.toString(Baza.get(i).getRatalunara()));
            Data1.add(Data3);
        }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        Sterge.add(Tabel);
        TextField input=new TextField();
        input.setBounds(130,300,200,20);
        Sterge.add(input);
        JButton submit=new JButton("Submit");
        Sterge.add(submit);
        submit.setBounds(130,330,200,40);

        JButton Revenire=new JButton("Revenire");
        Revenire.addActionListener(e -> Sterge.dispose());
        Revenire.setBounds(130,400,200,40);
        submit.setBounds(130,350,200,40);
        submit.addActionListener(e->{
            Sterge.dispose();
            int decizie=Integer.parseInt(input.getText());
            DelSalariat(decizie-1);

            try{
                write();}
            catch (Exception E){
                System.out.println("Eroare scriere");
            JFrame mesaj=new JFrame();
            Label Text=new Label("Stergere efectuata cu succes!");
            mesaj.add(Text);
            JButton Dismiss=new JButton("OK");
            mesaj.add(Dismiss);
            Text.setBounds(10,10,20,10);
            Dismiss.setBounds(20,10,20,10);
            Dismiss.addActionListener(l-> mesaj.dispose());
            mesaj.setSize(100,100);
            mesaj.setLayout(null);
            mesaj.setVisible(true);
            }});
        Sterge.add(Revenire);
        Sterge.add(submit);
        Sterge.setSize(500,1000);
        Sterge.setLayout(null);
        Sterge.setVisible(true);
    }
    public void updateG(int d){
        JFrame Submeniu1=new JFrame();
        Label Add=new Label("Va rog introduceti datele noului angajat!");
        Add.setBounds(100,50,300,20);
        TextField T1=new TextField();
        Label ID=new Label("ID:");
        ID.setBounds(100,130,60,20);
        T1.setBounds(150,130,200,20);
        TextField T2=new TextField();
        Label Nume=new Label("Nume:");
        Nume.setBounds(100,150,60,20);
        T2.setBounds(150,150,200,20);
        TextField T3=new TextField();
        Label Ziua=new Label("Ziua:");
        Ziua.setBounds(100,170,60,20);
        T3.setBounds(150,170,200,20);
        TextField T4=new TextField();
        Label Luna=new Label("Luna:");
        Luna.setBounds(100,190,60,20);
        T4.setBounds(150,190,200,20);
        TextField T5=new TextField();
        T5.setBounds(150,210,200,20);
        Label Varsta=new Label("Varsta:");
        Varsta.setBounds(100,210,60,20);
        TextField T6=new TextField();
        T6.setBounds(150,230,200,20);
        Label Salar=new Label("Salar");
        Salar.setBounds(100,230,60,20);
        TextField T7=new TextField();
        Label Rata=new Label("Rata:");
        Rata.setBounds(100,250,60,20);
        T7.setBounds(150,250,200,20);

        JButton Submit=new JButton("Submit");
        Submit.setBounds(150,300,200,50);
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int ziua,luna,varsta;
                long rata,salar;
                String ID,nume;
                ID=T1.getText();
                nume=T2.getText();
                ziua=Integer.parseInt(T3.getText());
                luna=Integer.parseInt(T4.getText());
                varsta=Integer.parseInt(T5.getText());
                salar=Long.parseLong(T6.getText());
                rata=Long.parseLong(T7.getText());

                DataNastere D=new DataNastere(ziua,luna,varsta);
                Salariat S=new Salariat(ID,nume,D,salar,rata);
                update(d,S);
                Label Succes=new Label("Angajat actualizat!");
                Succes.setBounds(150,400,200,20);
                Submeniu1.add(Succes);
            }
        });
        JButton Revenire=new JButton("Revenire");
        Revenire.setBounds(150,350,200,50);
        Revenire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Submeniu1.dispose();
            }
        });

        Submeniu1.add(Add);
        Submeniu1.add(T1);
        Submeniu1.add(ID);
        Submeniu1.add(T2);
        Submeniu1.add(Nume);
        Submeniu1.add(T3);
        Submeniu1.add(Ziua);
        Submeniu1.add(T4);
        Submeniu1.add(Luna);
        Submeniu1.add(T5);
        Submeniu1.add(Varsta);
        Submeniu1.add(T6);
        Submeniu1.add(Salar);
        Submeniu1.add(T7);
        Submeniu1.add(Rata);
        Submeniu1.add(Submit);
        Submeniu1.add(Revenire);

        Submeniu1.setSize(500,1000);
        Submeniu1.setLayout(null);
        Submeniu1.setVisible(true);
    }
    public void updateGUI(){
        JFrame baza=new JFrame();
        int amount=1;
        Vector<Vector<String>> Data1=new Vector<>();
        Vector<Vector<String>> Data;
        Vector<String> column=createcolumn(new String[]{"ID","Nume","Ziua-Luna-Var","Venit","Rata lunara"});
        for(int i=0;i<Baza.size();i++){
            Vector<String> Data3=new Vector<>();
            Data3.add(Integer.toString(amount));
            amount++;
            Data3.add(Baza.get(i).getNume());
            Data3.add(Baza.get(i).getD().toString());
            Data3.add(Baza.get(i).getSalariu().toString());
            Data3.add(Long.toString(Baza.get(i).getRatalunara()));
            Data1.add(Data3);
        }
        Data=createData(Data1,column);
        JTable Tabel=crearetabel(Data,column);
        baza.add(Tabel);
        TextField input=new TextField();
        input.setBounds(130,300,200,20);
        baza.add(input);
        JButton submit=new JButton("Submit");
        baza.add(submit);
        submit.setBounds(130,330,200,40);
        Button Revenire=new Button("Revenire");
        Revenire.setBounds(130,380,200,40);
        Revenire.addActionListener(e -> baza.dispose());
        submit.addActionListener(e->{
            baza.dispose();
            int decizie=Integer.parseInt(input.getText());
            updateG(decizie-1);
            try{
                write();}
            catch (Exception E){
                System.out.println("Eroare scriere");
            }
        });
        baza.add(Revenire);

        baza.setSize(500,1000);
        baza.setLayout(null);
        baza.setVisible(true);

    }
}
