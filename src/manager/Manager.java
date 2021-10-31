package manager;


import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Manager {
    private ArrayList<Character> goodPeople;
    private ArrayList<Character> badPeople;
    private Character[] allPlayers;
    public Manager() {
        this.goodPeople = new ArrayList<>();
        this.badPeople = new ArrayList<>();
        this.allPlayers = new Character[]{
                new Abomination(),
                new CazaRecompensas(),
                new AsaltaTumbas(),
                new Bandolero()
        };
    }
    public void init() {
        Scanner sc = new Scanner(System.in);
        menuInicial(sc);
        showMenu(sc);

    }



    private void menuInicial(Scanner sc) {
        System.out.println("Escoge 4 personajes");
        int num = 1;
        do {
            System.out.println("Personaje " + num);
            for (int i = 0; i < this.allPlayers.length; i++) {
                System.out.println(i + " - " + this.allPlayers[i].toString());
            }
            //TO DO -> CONTROL BY UTILS
            int select = sc.nextInt();
            this.goodPeople.add(this.allPlayers[select]);
            num++;
        } while (num < 5);
    }
    private void showMenu(Scanner sc){
        System.out.println("-> INICIANDO PARTIDA <-");
        do {
            System.out.println("Personajes:");
            showCharacters();
            System.out.println("1 - Explorar mazmorra\n2 - Descansar\n3 - Reordenar\n0 - Finalizar partida");
            int select = sc.nextInt();
            switch(select){
                case 1:
                    newDungeon(sc);
                    break;
                case 2:
                    descansar();
                    break;
                case 3:
                    reordenar(sc);
                    break;
                default:
                    System.err.println("OPCION INCORRECTA!");
                    break;
            }
        } while (true);
    }
    private void reordenar(Scanner sc) {
        int posOut, posIn;
        for (int i = 0; i < this.goodPeople.size(); i++) {
            System.out.println(i + " - " + this.goodPeople.get(i).toString());
        }
        System.out.println("¿Que personaje quieres mover?");
        posOut = sc.nextInt();
        System.out .println("¿A que posicion?");
        posIn = sc.nextInt();
        //Si el cambio posicion es de
        if(posIn != posOut){
            if(!(posIn > posOut)) {
                posIn = posIn + posOut;
                posOut = posIn - posOut;
                posIn = posIn - posOut;
            }
            //Cambio de posicion
            Collections.swap(this.goodPeople, posOut, posIn);
        }
        showCharacters();
    }

    private void descansar() {
        this.goodPeople.forEach(goodPerson -> goodPerson.descansar());
    }

    private void newDungeon(Scanner sc) {
        this.goodPeople.forEach(person -> {
            int hurt = 0;
            if(person.isAlive()){
                System.out.println(person);
                hurt = person.menu(sc);
                person.movementEnemiesClose(this.badPeople, hurt);
                
                //(this.badPeople, hurt);

            } else {

            }
        });
    }

    private void generarEnemigos() {
        int rnd = aleatorio() + 1;
        for (int i = 0; i < rnd; i++) {
            this.badPeople.add(this.allPlayers[aleatorio()]);
        }
    }

    private int aleatorio() {
        return new Random().nextInt(4);
    }

    private void showCharacters() {
        for (Character goodPerson : this.goodPeople) {
            System.out.println(goodPerson.toString());
        }
    }
}
