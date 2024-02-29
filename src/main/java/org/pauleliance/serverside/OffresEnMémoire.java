package org.pauleliance.serverside;

import org.pauleliance.domain.Offre;
import org.pauleliance.domain.TypeOffre;
import org.pauleliance.domain.ports.serverside.Offres;

import java.util.List;

public class OffresEnMémoire implements Offres {
    @Override
    public void créer(TypeOffre typeOffre, int i) {
    }

    @Override
    public List<Offre> disponibles() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
