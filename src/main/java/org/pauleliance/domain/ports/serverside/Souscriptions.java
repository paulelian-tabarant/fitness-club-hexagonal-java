package org.pauleliance.domain.ports.serverside;

import org.pauleliance.domain.Souscription;

import java.util.List;

public interface Souscriptions {
    void ajouter(String nomPersonne, String identifiantOffre);

    List<Souscription> enregistrées();
}
