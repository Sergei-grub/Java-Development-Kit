package Interfaces;

public interface Human {
    default void walk(){
        System.out.println("Walks on two feet");
    }
    void talk();
}
