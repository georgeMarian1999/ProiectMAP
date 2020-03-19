package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

public class GUI {
    private CTRL C;

    public GUI(){
        C=new CTRL();
        C.citire();
    }
    public void  afisaremeniu(){
        JFrame Meniu1=new JFrame();
        Label Welcome=new Label("Bine ati venit!");
        Label Welcome2=new Label("Va rog alegeti o optiune!");
        Welcome.setBounds(210,50,100,20);
        Welcome2.setBounds(170,70,200,20);

        JButton adauga =new JButton("Adauga un angajat");
        adauga.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                    C.adaugareGUI();
            }
        });
        adauga.setBounds(150,90,200,50);
        JButton update =new JButton("Update un angajat");
        update.setBounds(150,140,200,50);
        update.addActionListener(e->{
            C.UpdateGUI();
        });
        JButton sterge =new JButton("Sterge un angajat");
        sterge.setBounds(150,190,200,50);
        sterge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                C.StergeGUI();
            }
        });
        JButton afiseaza1 =new JButton("Adaosuri la salar");
        afiseaza1.setBounds(150,240,200,50);
        afiseaza1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C.afisareadaosuriGUI();
            }
        });
        JButton afiseaza2 =new JButton("Retrageri din salar");
        afiseaza2.setBounds(150,290,200,50);
        afiseaza2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C.afisaredeductiGUI();
            }
        });
        JButton afiseaza3 =new JButton("Venit mai mic ca si media");
        afiseaza3.setBounds(150,340,200,50);
        afiseaza3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C.afisaremediaGUI();
            }
        });
        JButton afiseaza4 =new JButton("Varsta de pensionare");
        afiseaza4.setBounds(150,390,200,50);
        afiseaza4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C.afisarepensGUI();
            }
        });
        JButton afiseaza5 =new JButton("Suma ratelor");
        afiseaza5.setBounds(150,440,200,50);
        afiseaza5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                C.afisarerateGUI();
            }
        });
        JButton afiseaza6=new JButton("Afisare baza de date");
        afiseaza6.setBounds(150,490,200,50);
        afiseaza6.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                C.afisarebazaGUI();
            }
        });
        JButton iesire=new JButton("Iesire");
        iesire.setBounds(150,540,200,50);
        iesire.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Meniu1.dispose();
            }
        });
        Meniu1.add(Welcome);
        Meniu1.add(Welcome2);
        Meniu1.add(adauga);
        Meniu1.add(update);
        Meniu1.add(sterge);
        Meniu1.add(afiseaza1);
        Meniu1.add(afiseaza2);
        Meniu1.add(afiseaza3);
        Meniu1.add(afiseaza4);
        Meniu1.add(afiseaza5);
        Meniu1.add(afiseaza6);
        Meniu1.add(iesire);
        Meniu1.setSize(500,1000);
        Meniu1.setLayout(null);
        Meniu1.setVisible(true);
    }

}
