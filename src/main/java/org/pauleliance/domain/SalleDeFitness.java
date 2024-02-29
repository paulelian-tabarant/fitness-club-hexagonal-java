package org.pauleliance.domain;

import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;
import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class SalleDeFitness implements CréerOffre, SouscrireOffre, ConsulterChiffreAffaires {
    private final Offres offres;
    private final Souscriptions souscriptions;

    public SalleDeFitness(Offres offres, Souscriptions souscriptions) {
        this.offres = offres;
        this.souscriptions = souscriptions;
    }

    @Override
    public void exécuter(TypeOffre type, Integer prixEnEuros) {
        offres.créer(type, prixEnEuros);
    }

    @Override
    public void exécuter(String nomPersonne, String identifiantOffre) {
        souscriptions.ajouter(nomPersonne, identifiantOffre);
    }

    @Override
    public Object exécuter() {
        throw new UnsupportedOperationException("not yet implemented");
    }
}