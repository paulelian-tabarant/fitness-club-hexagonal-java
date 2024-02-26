package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.CréerOffre;

public class CommandesInput {
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = Interpréteur.argumentÀ(offreCommande, 0);

        new InterpréteurFactory(créerOffre, souscrireOffre).pour(commande)
                .interpréter(offreCommande);
    }
}
