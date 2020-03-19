package com.company;

public class CTRL {
    private Firma F;

    public CTRL(){
        F=new Firma();
    }

    public Firma getF() {
        return F;
    }

    public void setF(Firma f) {
        F = f;
    }
    public void citire(){
        try{
            F=new Firma();
        F.read();}
        catch(Exception e){
            e.getCause();
            System.out.println("Citire nereusita");
        }
    }
    public void scrie(){
        try{
            F.write();}
        catch(Exception e){
            System.out.println("Scriere nereusita");
        }
    }

    public void Add(Salariat S){
        F.AddSalariat(S);
        try{
        F.write();}
        catch (Exception E){
            System.out.println("Eroare scriere");
        }
    }
    public void Del(int i){
        F.DelSalariat(i);
        try{
            F.write();}
        catch (Exception E){
            System.out.println("Eroare scriere");
        }
    }
    public void update(int i,Salariat S){
        F.update(i,S);
        try{
            F.write();}
        catch (Exception E){
            System.out.println("Eroare scriere");
        }
    }
    public void afisarescurta(){
        F.afisarelistaang();
    }
    public void afisareSalPens(){
        F.afisareSalPens();
    }
    public void afisaremedia(){
        F.afisaremedia();
    }
    public void afisareRate(){
        F.afisareRate();
    }
    public void afisarededucti(){
        F.afisaredeductii();
    }
    public void afisareprime(){
        F.afisareprime();
    }
    public void afisare(){
        F.afisare();
    }
    public void adaugareGUI(){
        F.adaugareGUI();
        try{
            F.write();}
        catch (Exception E){
            System.out.println("Eroare scriere");
        }
    }
    public void afisarebazaGUI(){F.afisarebazadatGUI();}
    public void afisaredeductiGUI(){
        F.afisaredeductiiGUI();
    }
    public void afisareadaosuriGUI(){
        F.afisareadaousGUI();
    }
    public void afisaremediaGUI(){
        F.afisaremaimiccamediaGUI();
    }
    public void afisarerateGUI(){
        F.afisarerataGUI();
    }
    public void afisarepensGUI(){
        F.afisarepensGUI();
    }
    public void StergeGUI(){
        F.stergeGUI();
        try{
            F.write();}
        catch (Exception E){
            System.out.println("Eroare scriere");
        }
    }
    public void UpdateGUI(){
        F.updateGUI();
    }

}
