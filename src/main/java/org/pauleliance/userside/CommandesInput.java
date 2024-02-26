package org.pauleliance.userside;

import org.pauleliance.domain.Sortie;
import org.pauleliance.domain.SouscrireOffre;
import org.pauleliance.domain.CréerOffre;

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
