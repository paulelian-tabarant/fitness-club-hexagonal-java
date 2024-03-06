package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourConsulterLeChiffreDAffaires;
import org.pauleliance.domain.ports.userside.Sortie;

public class ConsulterChiffreAffairesCommandeTextuelle implements CommandeTextuelle {
    private final PourConsulterLeChiffreDAffaires port;
    private final Sortie sortie;

    public ConsulterChiffreAffairesCommandeTextuelle(PourConsulterLeChiffreDAffaires port, Sortie sortie) {
        this.port = port;
        this.sortie = sortie;
    }

    @Override
    public void exécuter(String instruction) {
        sortie.envoyer("Chiffre d'affaires du mois : " + port.consulterLeChiffreDAffaires() + "€");
    }
}
