package org.pauleliance.userside;

import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class CommandeTextuelleFactory {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    public static final String CONSULTER_CHIFFRE_D_AFFAIRES = "ca";
    private static final String CONSULTER_OFFRES_DISPONIBLES = "offres";

    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;
    private final PourConsulterChiffreAffaires pourConsulterChiffreAffaires;
    private final ConsulterOffresDisponibles consulterOffres;

    private final Sortie sortie;

    public CommandeTextuelleFactory(CréerOffre créerOffre,
                                    SouscrireOffre souscrireOffre,
                                    PourConsulterChiffreAffaires pourConsulterChiffreAffaires,
                                    ConsulterOffresDisponibles consulterOffres,
                                    Sortie sortie) {

        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
        this.pourConsulterChiffreAffaires = pourConsulterChiffreAffaires;
        this.consulterOffres = consulterOffres;
        this.sortie = sortie;
    }

    public CommandeTextuelle pour(String commande) {
        if (commande.equals(CRÉER_OFFRE)) {
            return new CréerOffreCommandeTextuelle(créerOffre);
        }

        if (commande.equals(CONSULTER_OFFRES_DISPONIBLES)) {
            return new ConsulterOffresDisponiblesCommandeTextuelle(consulterOffres, sortie);
        }

        if (commande.equals(SOUSCRIRE_OFFRE)) {
            return new SouscrireOffreCommandeTextuelle(souscrireOffre);
        }

        if (commande.equals(CONSULTER_CHIFFRE_D_AFFAIRES)) {
            return new ConsulterChiffreAffairesCommandeTextuelle(pourConsulterChiffreAffaires, sortie);
        }

        throw new UnsupportedOperationException("not yet implemented");
    }
}
