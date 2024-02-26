package org.pauleliance.userside;

public interface Interpréteur {

    void interpréter(String offreCommande);

    static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
