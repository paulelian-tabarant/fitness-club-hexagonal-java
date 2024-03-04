package org.pauleliance.userside;

import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class InterpréteurFactory {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    public static final String CONSULTER_CHIFFRE_D_AFFAIRES = "ca";
    private static final String CONSULTER_OFFRES_DISPONIBLES = "offres";

    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;
    private final ConsulterChiffreAffaires consulterChiffreAffaires;
    private final ConsulterOffresDisponibles consulterOffres;

    private final Sortie sortie;

    public InterpréteurFactory(CréerOffre créerOffre,
                               SouscrireOffre souscrireOffre,
                               ConsulterChiffreAffaires consulterChiffreAffaires,
                               ConsulterOffresDisponibles consulterOffres,
                               Sortie sortie) {

        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
        this.consulterChiffreAffaires = consulterChiffreAffaires;
        this.consulterOffres = consulterOffres;
        this.sortie = sortie;
    }

    public Interpréteur pour(String commande) {
        if (commande.equals(CRÉER_OFFRE)) {
            return new CréerOffreInterpréteur(créerOffre);
        }

        if (commande.equals(CONSULTER_OFFRES_DISPONIBLES)) {
            return new ConsulterOffresDisponiblesInterpréteur(consulterOffres, sortie);
        }

        if (commande.equals(SOUSCRIRE_OFFRE)) {
            return new SouscrireOffreInterpréteur(souscrireOffre);
        }

        if (commande.equals(CONSULTER_CHIFFRE_D_AFFAIRES)) {
            return new ConsulterChiffreAffairesInterpréteur(consulterChiffreAffaires, sortie);
        }

        throw new UnsupportedOperationException("not yet implemented");
    }
}
