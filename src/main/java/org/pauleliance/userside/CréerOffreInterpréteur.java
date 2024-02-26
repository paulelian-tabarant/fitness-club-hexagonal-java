package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.TypeOffre;

import static java.lang.Integer.parseInt;

public class CréerOffreInterpréteur implements Interpréteur {

    private final CréerOffre créerOffre;

    public CréerOffreInterpréteur(CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    @Override
    public void interpréter(String offreCommande) {
        var prixParMois = Interpréteur.argumentÀ(offreCommande, 2);

        créerOffre.exécuter(TypeOffre.MENSUELLE, parseInt(prixParMois));
    }

}
