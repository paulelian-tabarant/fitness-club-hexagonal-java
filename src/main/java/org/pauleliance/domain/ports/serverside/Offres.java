package org.pauleliance.domain.ports.serverside;

import org.pauleliance.domain.Offre;

import java.util.List;

public interface Offres {
    void créer(int prixEnEuros);

    List<Offre> disponibles();
}
