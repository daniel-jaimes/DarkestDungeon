package model;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Character {
    private int health;
    private int stress;
    private int minScope;
    private int maxScope;
    private boolean life;
    public Character(int health, int stress, int minScope, int maxScope) {
        this.health = health;
        this.stress = stress;
        this.minScope = minScope;
        this.maxScope = maxScope;
        this.life = true;
    }
    @Override
    public String toString(){
        return "[tipo=" + getTipo() + ", salud=" + this.health + ", estres=" + this.stress + "]";
    }
    protected String getTipo(){
        return "Soy la clase papasote";
    }
    public void descansar(){

    }
    //SETTERS
    void maxHealth(int health){
        this.health = health;
    }
    //HABILITIES
    public int habilidad1(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public int habilidad2(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public int habilidad3(){
        System.out.println("Habilidad basica");
        return 1;
    }
    public boolean checkStress(){
        return 0 < this.stress;
    }
    public void danar(int dano){
        if(this.health <= dano && this.health >= 0) this.life = false;
        else this.health -= dano;
        if (dano < 0){
            if(this.stress <= Math.abs(dano))this.life = false;
            else this.stress = this.stress - Math.abs(dano);
        }
    }
    //SETTERS
    private void setStress(int stress) {
        this.stress = stress;
    }
    private void setHealth(int health){
        this.health = health;
    }
    protected void recoverStress(int stress){
        setStress(getStress() + stress);
    }
    protected void recoverHealth(int health){
        setHealth(getHealth() + health);
    }
    //GETTERS
    protected int getStress() {
        return this.stress;
    }
    protected int getHealth(){
        return this.health;
    }


    public int menu(){
        //TODO
        int hurt = 0;
        System.out.println("Turno de: " + this);
        System.out.print("1 - " + descripcionHabilidad1() + "\n2 - " + descripcionHabilidad2() + "\n3 - " + descripcionHabilidad3());
        hurt += habilidad1();
        hurt += habilidad2();
        hurt += habilidad3();
        return hurt;
    }
    //DESCRIPCIONES DE HABILIDAD
    String descripcionHabilidad1() {
        return "Habilidad1 - no tiene efecto";
    }
    String descripcionHabilidad2() {
        return "Habilidad2 - no tiene efecto";
    }
    String descripcionHabilidad3() {
        return "Habilidad3 - no tiene efecto";
    }

    public int habilidadRandom(int valor){
        if(valor >= 0 && valor <= 3){
            if(valor == 0) return habilidad1();
            else if(valor == 1) return habilidad2();
            else if(valor == 2) return habilidad3();
            else return 0;
        }
        return -1;
    }

    public boolean isAlive() {
        return this.life;
    }
    public void movementEnemiesClose(ArrayList<Character> badPeople, int hurt){
        Scanner sc = new Scanner(System.in);
        boolean out_of_range = this.maxScope > badPeople.size();
        int index_max = this.maxScope, select;
        if(out_of_range) index_max = badPeople.size();
        ArrayList<Character> auxBadPeople = (ArrayList<Character>) badPeople.subList(this.minScope - 1, index_max - 1);
        do {
            AtomicInteger i = new AtomicInteger(1);
            auxBadPeople.forEach(enemies -> {
                System.out.println(i + " - " + enemies.toString());
                i.getAndIncrement();
            });
            select = sc.nextInt();
            out_of_range = select < 1 || select > auxBadPeople.size();
            if(!out_of_range) {
                badPeople.get((this.minScope - 1) + select).danar(hurt);
                select = (this.minScope - 1) + select;
            }
        }while(out_of_range);
        if(!badPeople.get(select).isAlive()) badPeople.remove(select);
    }

}