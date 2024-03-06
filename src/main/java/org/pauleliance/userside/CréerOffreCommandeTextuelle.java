package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourCréerUneOffre;

import static java.lang.Integer.parseInt;

public class CréerOffreCommandeTextuelle implements CommandeTextuelle {

    private final PourCréerUneOffre port;

    public CréerOffreCommandeTextuelle(PourCréerUneOffre port) {
        this.port = port;
    }

    @Override
    public void exécuter(String instruction) {
        var code = CommandeTextuelle.argumentÀ(instruction, 1);
        var prixParMois = CommandeTextuelle.argumentÀ(instruction, 2);

        port.créerUneOffre(code, parseInt(prixParMois));
    }

}
