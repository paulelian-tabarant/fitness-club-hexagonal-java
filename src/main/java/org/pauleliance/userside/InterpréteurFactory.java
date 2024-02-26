package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.CréerOffre;

import java.util.Objects;

public class InterpréteurFactory {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";

    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public InterpréteurFactory(CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public Interpréteur pour(String commande) {
        if (isCréerOffre(commande)) {
            return new CréerOffreInterpréteur(créerOffre);
        }

        if (isSouscrireOffre(commande)) {
            return new SouscrireOffreInterpréteur(souscrireOffre);
        }

        throw new UnsupportedOperationException("not yet implemented");
    }

    private static boolean isCréerOffre(String commande) {
        return Objects.equals(commande, CRÉER_OFFRE);
    }

    private static boolean isSouscrireOffre(String commande) {
        return Objects.equals(commande, SOUSCRIRE_OFFRE);
    }
}
