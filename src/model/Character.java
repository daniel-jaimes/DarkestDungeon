package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Character {
    private int health;
    private int stress;
    private int minScope;
    private int maxScope;
    private boolean life;
    private int level;
    public Character(int health, int stress, int minScope, int maxScope) {
        this.health = health;
        this.stress = stress;
        this.minScope = minScope;
        this.maxScope = maxScope;
        this.life = true;
        this.level = 1;
    }
    public Character(int minScope, int maxScope){
        this.minScope = minScope;
        this.maxScope = maxScope;
        this.life = true;
        this.level = 1;
    }
    void setHealthAndStress(int health, int stress){
        this.health = health;
        this.stress = stress;
    }
    public Character copy(){
        return new Character(this.health, this.stress, this.minScope, this.maxScope);
    }
    @Override
    public String toString(){
        return "[tipo=" + getTipo() + ", salud=" + this.health + ", estres=" + this.stress + "]";
    }
    public void descansar(){

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

    public void danar(int dano){
        if(this.health <= dano && this.health >= 0){
            System.out.println(this + " ha muerto por la salud!");
            this.life = false;
        }
        else this.health -= dano;
        if (dano < 0){
            if(this.stress + Math.abs(dano) >= 10){
                System.out.println(this + " ha muerto por el estres!");
                this.life = false;
            }
            else this.stress = this.stress + Math.abs(dano);
        }
    }
    //SETTERS
    void setStress(int stress) {
        this.stress = stress;
    }
    void setHealth(int health){
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
    protected String getTipo(){
        return "Soy la clase papasote";
    }
    public boolean checkStress(){
        return 0 < this.stress;
    }

    public int menu(Scanner sc){
        int hurt = 0;
        do {
            System.out.println("1 - " + descripcionHabilidad1() +
                    "\n2 - " + descripcionHabilidad2() +
                    "\n3 - " + descripcionHabilidad3());
            switch(sc.nextInt()){
                case 1:
                    hurt = habilidad1();
                    break;
                case 2:
                    hurt = habilidad2();
                    break;
                case 3:
                    hurt = habilidad3();
                    break;
                default:
                    System.err.println("Eleccion erronea");
                    break;
            }
        } while(hurt == 0);
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
        if(valor == 0) return habilidad1();
        else if(valor == 1) return habilidad2();
        else if(valor == 2) return habilidad3();
        else return 0;
    }

    public boolean isAlive() {
        return this.life;
    }
    public void movementEnemiesClose(ArrayList<Character> badPeople, int hurt, Scanner sc){
        boolean out_of_range = this.maxScope > badPeople.size() + 1;
        int index_max, select;
        if(out_of_range) index_max = badPeople.size();
        else index_max = this.maxScope;
        List<Character> auxBadPeople = badPeople.subList(this.minScope - 1, index_max);
        do {
            System.out.println("¿A quien quieres a atacar?");
            AtomicInteger i = new AtomicInteger(1);
            auxBadPeople.forEach(enemies -> {
                System.out.println(i + " - " + enemies.toString());
                i.getAndIncrement();
            });
            select = sc.nextInt();
            out_of_range = select < 1 || select > auxBadPeople.size();
            if(!out_of_range) {
                badPeople.get(select - 1).danar(hurt);
            }
        }while(out_of_range);
        if(!badPeople.get(select).isAlive()) badPeople.remove(select);
    }
    public void updateHealthAndStress(){
        this.level++;
        setHealth(getHealth() * this.level);
        setStress(getStress() * this.level);
    }



}