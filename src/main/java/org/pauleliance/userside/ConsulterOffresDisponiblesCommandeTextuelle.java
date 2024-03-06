package org.pauleliance.userside;

import org.pauleliance.domain.Offre;
import org.pauleliance.domain.ports.userside.PourConsulterLesOffresDisponibles;
import org.pauleliance.domain.ports.userside.Sortie;

import java.util.List;

public class ConsulterOffresDisponiblesCommandeTextuelle implements CommandeTextuelle {

    private final PourConsulterLesOffresDisponibles port;
    private final Sortie sortie;

    ConsulterOffresDisponiblesCommandeTextuelle(PourConsulterLesOffresDisponibles pourConsulterLesOffresDisponibles, Sortie sortie) {
        this.port = pourConsulterLesOffresDisponibles;
        this.sortie = sortie;
    }

    @Override
    public void exécuter(String instruction) {
        List<Offre> offres = port.consulterLesOffresDisponibles();

        if (offres.isEmpty()) return;

        var identifiantsOffres = offres.stream().map(Offre::code).toList();

        sortie.envoyer(String.join(" ", identifiantsOffres));
    }
}
