package org.pauleliance.userside;

public interface CommandeTextuelle {

    void exécuter(String instruction);

    static String argumentÀ(String instruction, int position) {
        return instruction.split(" ")[position];
    }
}
