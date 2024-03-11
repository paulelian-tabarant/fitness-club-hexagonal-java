package org.pauleliance.domain.ports.serverside;

import org.pauleliance.domain.Souscription;

import java.util.List;

public interface Souscriptions {
    // TODO: méthode "persister" auquel on passe directement l'objet métier Souscription
    // avec la méthode Factory qui va bien pour la créer (même signature que ci-dessous)
    void ajouter(String nomPersonne, String identifiantOffre);

    List<Souscription> enregistrées();
}
