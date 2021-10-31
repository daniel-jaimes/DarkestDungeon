package manager;


import model.*;
import model.Character;

import java.util.*;

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
        generarEnemigos();
        showMenu(sc);
        sc.close();
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
        boolean globalHealth, checkSaludEnemies, checkSaludGoodPeople;
        globalHealth = checkSaludEnemies = checkSaludGoodPeople = true;
        System.out.println("-> INICIANDO PARTIDA <-");
        do {
            System.out.println("Personajes:");
            showCharacters();
            System.out.println("1 - Explorar mazmorra\n2 - Descansar\n3 - Reordenar\n0 - Finalizar partida");
            int select = sc.nextInt();
            switch(select){
                case 1:
                    newDungeon(sc, checkSaludEnemies, checkSaludGoodPeople);
                    if(!checkSaludEnemies) System.out.println("HAN MUERTO TODOS LOS ENEMIGOS");
                    if(!checkSaludGoodPeople) System.out.println("HAN MUERTO TODOS LOS PERSONAJES");
                    globalHealth = checkSaludEnemies && checkSaludGoodPeople;
                    break;
                case 2:
                    descansar();
                    break;
                case 3:
                    reordenar(sc);
                    break;
                case 0:
                    globalHealth = false;
                    break;
                default:
                    System.err.println("OPCION INCORRECTA!");
                    break;
            }
        } while (globalHealth);
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
        if(posIn != posOut){
            if(!(posIn > posOut)) {
                posIn = posIn + posOut;
                posOut = posIn - posOut;
                posIn = posIn - posOut;
            }
            Collections.swap(this.goodPeople, posOut, posIn);
        }
        showCharacters();
    }

    private void descansar() {
        this.goodPeople.forEach(goodPerson -> goodPerson.descansar());
    }

    private void newDungeon(Scanner sc, boolean checkSaludEnemies, boolean checkSaludGoodPeople) {
        this.goodPeople.forEach(person -> {
            int hurt;
            if(person.isAlive()){
                System.out.println("Turno de: " + person);
                hurt = person.menu(sc);
                person.movementEnemiesClose(this.badPeople, hurt, sc);
            }
        });
        checkSaludEnemies = checkSalud((Character[]) this.badPeople.toArray());
        if(checkSaludEnemies) {
            this.badPeople.forEach(badboy -> {
                int rnd = aleatorio();
                int hurt = badboy.habilidadRandom(aleatorio());
                if(rnd <= this.goodPeople.size() || hurt == 0){
                    if(this.goodPeople.get(rnd).isAlive()){
                        this.goodPeople.get(rnd).danar(hurt);
                    } else {
                        this.goodPeople.remove(rnd);
                    }
                } else System.out.println("Enemigo ha fallado el ataque");
            });
        }
        checkSaludGoodPeople = checkSalud((Character[]) this.goodPeople.toArray());
    }
    private boolean checkSalud(Character[] players){
        for (Character guy : players) {
            if(guy.isAlive()) return true;
        }
        return false;
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
