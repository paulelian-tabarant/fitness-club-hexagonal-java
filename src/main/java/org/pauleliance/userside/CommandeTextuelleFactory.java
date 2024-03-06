package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourConsulterLesOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterLeChiffreDAffaires;
import org.pauleliance.domain.ports.userside.PourCréerUneOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.PourSouscrireÀUneOffre;

public class CommandeTextuelleFactory {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    public static final String CONSULTER_CHIFFRE_D_AFFAIRES = "ca";
    private static final String CONSULTER_OFFRES_DISPONIBLES = "offres";

    private final PourCréerUneOffre pourCréerUneOffre;
    private final PourSouscrireÀUneOffre pourSouscrireÀUneOffre;
    private final PourConsulterLeChiffreDAffaires pourConsulterLeChiffreDAffaires;
    private final PourConsulterLesOffresDisponibles consulterOffres;

    private final Sortie sortie;

    public CommandeTextuelleFactory(PourCréerUneOffre pourCréerUneOffre,
                                    PourSouscrireÀUneOffre pourSouscrireÀUneOffre,
                                    PourConsulterLeChiffreDAffaires pourConsulterLeChiffreDAffaires,
                                    PourConsulterLesOffresDisponibles consulterOffres,
                                    Sortie sortie) {

        this.pourCréerUneOffre = pourCréerUneOffre;
        this.pourSouscrireÀUneOffre = pourSouscrireÀUneOffre;
        this.pourConsulterLeChiffreDAffaires = pourConsulterLeChiffreDAffaires;
        this.consulterOffres = consulterOffres;
        this.sortie = sortie;
    }

    public CommandeTextuelle pour(String commande) {
        if (commande.equals(CRÉER_OFFRE)) {
            return new CréerOffreCommandeTextuelle(pourCréerUneOffre);
        }

        if (commande.equals(CONSULTER_OFFRES_DISPONIBLES)) {
            return new ConsulterOffresDisponiblesCommandeTextuelle(consulterOffres, sortie);
        }

        if (commande.equals(SOUSCRIRE_OFFRE)) {
            return new SouscrireOffreCommandeTextuelle(pourSouscrireÀUneOffre);
        }

        if (commande.equals(CONSULTER_CHIFFRE_D_AFFAIRES)) {
            return new ConsulterChiffreAffairesCommandeTextuelle(pourConsulterLeChiffreDAffaires, sortie);
        }

        throw new UnsupportedOperationException("not yet implemented");
    }
}
