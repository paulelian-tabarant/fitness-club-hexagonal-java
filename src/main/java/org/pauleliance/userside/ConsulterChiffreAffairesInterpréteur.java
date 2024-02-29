package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.Sortie;

public class ConsulterChiffreAffairesInterpréteur implements Interpréteur {
    private final ConsulterChiffreAffaires consulterChiffreAffaires;
    private final Sortie sortie;

    public ConsulterChiffreAffairesInterpréteur(ConsulterChiffreAffaires consulterCA, Sortie sortie) {
        this.consulterChiffreAffaires = consulterCA;
        this.sortie = sortie;
    }

    @Override
    public void lancer(String commande) {
        var chiffreAffaires = consulterChiffreAffaires.exécuter();
        sortie.envoyer("Chiffre d'affaires du mois : " + chiffreAffaires + "€");
    }
}
