package org.pauleliance.userside;

public interface Interpréteur {

    void lancer(String offreCommande);

    static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
