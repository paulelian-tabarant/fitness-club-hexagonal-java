package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.CréerOffre;

public class CommandesInput {
    private final Sortie sortie;
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    private final ConsulterChiffreAffaires consulterCA;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre, ConsulterChiffreAffaires consulterCA) {
        this.sortie = sortie;
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
        this.consulterCA = consulterCA;
    }

    public void exécuter(String offreCommande) {
        String commande = Interpréteur.argumentÀ(offreCommande, 0);

        new InterpréteurFactory(créerOffre, souscrireOffre, consulterCA, sortie).pour(commande)
                .interpréter(offreCommande);
    }
}
