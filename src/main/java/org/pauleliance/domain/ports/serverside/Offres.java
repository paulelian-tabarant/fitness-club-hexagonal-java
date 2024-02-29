package org.pauleliance.domain.ports.serverside;

import org.pauleliance.domain.Offre;
import org.pauleliance.domain.TypeOffre;

import java.util.List;

public interface Offres {
    void créer(TypeOffre typeOffre, int i);

    List<Offre> disponibles();
}
