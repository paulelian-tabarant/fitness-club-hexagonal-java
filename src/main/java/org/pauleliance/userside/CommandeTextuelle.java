package org.pauleliance.userside;

public interface CommandeTextuelle {

    void exécuter(String... args);

    static String argumentÀ(String instruction, int position) {
        return instruction.split(" ")[position];
    }
}
