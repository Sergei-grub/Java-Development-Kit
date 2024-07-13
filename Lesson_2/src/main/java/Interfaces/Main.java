package Interfaces;

import java.util.Arrays;

public class Main {
    private static class Minotaurus implements Human, Bull{
        @Override
        public void walk(){
            System.out.println("Walks on two feet");
        }
        public void talk(){
            System.out.println("Asks you a riddle");
        }
    }
    public static void main(String[] args) {
        //new class
        Man man0 = new Man();
        Ox ox0 = new Ox();
        Bull minos0 = new Minotaurus();
        Human minos1 = new Minotaurus();

        //new interface
        Minotaurus minos = new Minotaurus();
        Human man1 = new Man();
        Bull ox2 = new Ox();
        Bull[] allBulls = {ox2, minos0, minos};
        Human[] allHumans = {man1, minos, minos1};

        man0.talk();
        ox2.walk();
        ox0.walk();


//        System.out.println(allHumans);
//        System.out.println(ox2);
//        System.out.println(ox0);
    }
}
