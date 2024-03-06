package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class SouscrireOffreCommandeTextuelle implements CommandeTextuelle {
    private final SouscrireOffre souscrireOffre;

    public SouscrireOffreCommandeTextuelle(SouscrireOffre souscrireOffre) {
        this.souscrireOffre = souscrireOffre;
    }

    @Override
    public void exécuter(String instruction) {
        var nomClient = CommandeTextuelle.argumentÀ(instruction, 1);
        var identifiantOffre = CommandeTextuelle.argumentÀ(instruction, 2);

        souscrireOffre.souscrireOffre(nomClient, identifiantOffre);
    }
}
