package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.CréerOffre;

public class InterpréteurFactory {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    public static final String CONSULTER_CHIFFRE_D_AFFAIRES = "ca";

    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;
    private final ConsulterChiffreAffaires consulterCA;
    private final Sortie sortie;

    public InterpréteurFactory(CréerOffre créerOffre, SouscrireOffre souscrireOffre, ConsulterChiffreAffaires consulterCA, Sortie sortie) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
        this.consulterCA = consulterCA;
        this.sortie = sortie;
    }

    public Interpréteur pour(String commande) {
        if (commande.equals(CRÉER_OFFRE)) {
            return new CréerOffreInterpréteur(créerOffre);
        }

        if (commande.equals(SOUSCRIRE_OFFRE)) {
            return new SouscrireOffreInterpréteur(souscrireOffre);
        }

        if (commande.equals(CONSULTER_CHIFFRE_D_AFFAIRES)) {
            return new ConsulterChiffreAffairesInterpréteur(consulterCA, sortie);
        }

        throw new UnsupportedOperationException("not yet implemented");
    }
}
