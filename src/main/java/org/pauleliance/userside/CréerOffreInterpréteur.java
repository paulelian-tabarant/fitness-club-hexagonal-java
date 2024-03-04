package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.CréerOffre;

import static java.lang.Integer.parseInt;

public class CréerOffreInterpréteur implements Interpréteur {

    private final CréerOffre créerOffre;

    public CréerOffreInterpréteur(CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    @Override
    public void interpréter(String instruction) {
        var code = Interpréteur.argumentÀ(instruction, 1);
        var prixParMois = Interpréteur.argumentÀ(instruction, 2);

        créerOffre.créerOffre(code, parseInt(prixParMois));
    }

}
