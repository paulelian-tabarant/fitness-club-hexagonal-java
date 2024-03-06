package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.CréerOffre;

import static java.lang.Integer.parseInt;

public class CréerOffreCommandeTextuelle implements CommandeTextuelle {

    private final CréerOffre créerOffre;

    public CréerOffreCommandeTextuelle(CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    @Override
    public void exécuter(String instruction) {
        var code = CommandeTextuelle.argumentÀ(instruction, 1);
        var prixParMois = CommandeTextuelle.argumentÀ(instruction, 2);

        créerOffre.créerOffre(code, parseInt(prixParMois));
    }

}
