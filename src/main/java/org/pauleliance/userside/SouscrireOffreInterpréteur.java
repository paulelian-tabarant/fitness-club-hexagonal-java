package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class SouscrireOffreInterpréteur implements Interpréteur {
    private final SouscrireOffre souscrireOffre;

    public SouscrireOffreInterpréteur(SouscrireOffre souscrireOffre) {
        this.souscrireOffre = souscrireOffre;
    }

    @Override
    public void interpréter(String offreCommande) {
        var nomPersonne = Interpréteur.argumentÀ(offreCommande, 1);
        var identifiantOffre = Interpréteur.argumentÀ(offreCommande, 2);

        souscrireOffre.exécuter(nomPersonne, identifiantOffre);
    }
}
