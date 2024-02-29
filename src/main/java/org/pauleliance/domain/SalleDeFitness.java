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
    public void exécuter(Integer prixEnEuros) {
        offres.créer(prixEnEuros);
    }

    @Override
    public void exécuter(String nomClient, String identifiantOffre) {
        souscriptions.ajouter(nomClient, identifiantOffre);
    }

    @Override
    public Integer exécuter() {
        var offresEnCours = offres.disponibles();
        var souscriptionsEnCours = souscriptions.enregistrées();

        var chiffreAffaires = 0;
        for (Souscription souscription : souscriptionsEnCours) {
            var offrePourSouscription = offresEnCours
                    .stream()
                    .filter(offre -> offre.identifiant().equals(souscription.identifiantOffre()))
                    .findFirst();

            chiffreAffaires += offrePourSouscription.map(Offre::prix).orElse(0);
        }

        return chiffreAffaires;
    }
}
