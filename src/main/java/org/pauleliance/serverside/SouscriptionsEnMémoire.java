package org.pauleliance.serverside;

import org.pauleliance.domain.Souscription;
import org.pauleliance.domain.ports.serverside.Souscriptions;

import java.util.List;

public class SouscriptionsEnMémoire implements Souscriptions {
    @Override
    public void ajouter(String nomPersonne, String identifiantOffre) {
    }

    @Override
    public List<Souscription> enregistrées() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
