package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.Sortie;

public class ConsulterChiffreAffairesInterpréteur implements Interpréteur {
    private final ConsulterChiffreAffaires consulterChiffreAffaires;
    private final Sortie sortie;

    public ConsulterChiffreAffairesInterpréteur(ConsulterChiffreAffaires consulterChiffreAffaires, Sortie sortie) {
        this.consulterChiffreAffaires = consulterChiffreAffaires;
        this.sortie = sortie;
    }

    @Override
    public void interpréter(String instruction) {
        var chiffreAffaires = consulterChiffreAffaires.consulterChiffreDAffaires();
        sortie.envoyer("Chiffre d'affaires du mois : " + chiffreAffaires + "€");
    }
}
