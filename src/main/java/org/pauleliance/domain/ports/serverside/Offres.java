package org.pauleliance.domain.ports.serverside;

import org.pauleliance.domain.Offre;

import java.util.List;

public interface Offres {

    // TODO: méthode "persister" auquel on passe directement l'objet métier Offre
    // (créée à partir d'une méthode factory de la classe Offre)
    void créer(String code, Integer prixEnEuros);

    List<Offre> disponibles();
}
