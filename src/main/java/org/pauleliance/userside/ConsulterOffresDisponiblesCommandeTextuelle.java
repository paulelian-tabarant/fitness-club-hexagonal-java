package org.pauleliance.userside;

import org.pauleliance.domain.Offre;
import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.Sortie;

import java.util.List;

public class ConsulterOffresDisponiblesCommandeTextuelle implements CommandeTextuelle {

    private final ConsulterOffresDisponibles port;
    private final Sortie sortie;

    ConsulterOffresDisponiblesCommandeTextuelle(ConsulterOffresDisponibles consulterOffresDisponibles, Sortie sortie) {
        this.port = consulterOffresDisponibles;
        this.sortie = sortie;
    }

    @Override
    public void exécuter(String instruction) {
        List<Offre> offres = port.consulterOffresDisponibles();

        if (offres.isEmpty()) return;

        var identifiantsOffres = offres.stream().map(Offre::code).toList();

        sortie.envoyer(String.join(" ", identifiantsOffres));
    }
}
