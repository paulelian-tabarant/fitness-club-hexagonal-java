package org.pauleliance.serverside;

import org.pauleliance.domain.Offre;
import org.pauleliance.domain.ports.serverside.Offres;

import java.util.ArrayList;
import java.util.List;

public class OffresEnMémoire implements Offres {
    private final List<Offre> offres = new ArrayList<>();

    @Override
    public void créer(String code, Integer prixEnEuros) {
        offres.add(new Offre(code, prixEnEuros));
    }

    @Override
    public List<Offre> disponibles() {
        return offres;
    }
}
