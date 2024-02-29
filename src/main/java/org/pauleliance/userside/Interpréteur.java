package org.pauleliance.userside;

public interface Interpréteur {

    void interpréter(String instruction);

    static String argumentÀ(String instruction, int position) {
        return instruction.split(" ")[position];
    }
}
