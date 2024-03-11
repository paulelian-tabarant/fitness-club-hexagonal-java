package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.PourConsulterLesOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterLeChiffreDAffaires;
import org.pauleliance.domain.ports.userside.PourCréerUneOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.PourSouscrireÀUneOffre;

public class EntréeTextuelle {

    private final CommandeTextuelleFactory commandeTextuelleFactory;

    public EntréeTextuelle(Sortie sortie,
                           PourCréerUneOffre pourCréerUneOffre,
                           PourSouscrireÀUneOffre pourSouscrireÀUneOffre,
                           PourConsulterLeChiffreDAffaires pourConsulterLeChiffreDAffaires,
                           PourConsulterLesOffresDisponibles pourConsulterLesOffresDisponibles) {

        this.commandeTextuelleFactory = new CommandeTextuelleFactory(pourCréerUneOffre,
                pourSouscrireÀUneOffre,
                pourConsulterLeChiffreDAffaires,
                pourConsulterLesOffresDisponibles,
                sortie);
    }

    public void interpréter(String instruction) {
        String nomCommande = CommandeTextuelle.argumentÀ(instruction, 0);

        commandeTextuelleFactory.pour(nomCommande).exécuter(instruction);
    }
}
