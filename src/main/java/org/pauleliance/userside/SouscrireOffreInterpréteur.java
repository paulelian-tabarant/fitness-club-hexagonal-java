package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class SouscrireOffreInterpréteur implements Interpréteur {
    private final SouscrireOffre souscrireOffre;

    public SouscrireOffreInterpréteur(SouscrireOffre souscrireOffre) {
        this.souscrireOffre = souscrireOffre;
    }

    @Override
    public void interpréter(String instruction) {
        var nomClient = Interpréteur.argumentÀ(instruction, 1);
        var identifiantOffre = Interpréteur.argumentÀ(instruction, 2);

        souscrireOffre.exécuter(nomClient, identifiantOffre);
    }
}
