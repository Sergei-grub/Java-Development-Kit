package Interfaces;

public interface Bull {
    int amount = 2;
    default void walk(){
        System.out.println("Walks on " + amount + " hooves!");
    }
    void talk();
}
