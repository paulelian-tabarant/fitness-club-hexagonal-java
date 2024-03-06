package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourSouscrireÀUneOffre;

public class SouscrireOffreCommandeTextuelle implements CommandeTextuelle {
    private final PourSouscrireÀUneOffre port;

    public SouscrireOffreCommandeTextuelle(PourSouscrireÀUneOffre port) {
        this.port = port;
    }

    @Override
    public void exécuter(String instruction) {
        var nomClient = CommandeTextuelle.argumentÀ(instruction, 1);
        var identifiantOffre = CommandeTextuelle.argumentÀ(instruction, 2);

        port.souscrireÀUneOffre(nomClient, identifiantOffre);
    }
}
