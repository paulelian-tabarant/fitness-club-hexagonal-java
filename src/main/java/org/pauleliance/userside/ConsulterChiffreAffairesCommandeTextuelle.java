package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.Sortie;

public class ConsulterChiffreAffairesCommandeTextuelle implements CommandeTextuelle {
    private final PourConsulterChiffreAffaires useCase;
    private final Sortie sortie;

    public ConsulterChiffreAffairesCommandeTextuelle(PourConsulterChiffreAffaires useCase, Sortie sortie) {
        this.useCase = useCase;
        this.sortie = sortie;
    }

    @Override
    public void exécuter(String instruction) {
        sortie.envoyer("Chiffre d'affaires du mois : " + useCase.consulterChiffreAffaires() + "€");
    }
}
