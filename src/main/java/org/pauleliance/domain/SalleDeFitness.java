package org.pauleliance.domain;

import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;
import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

import java.util.List;

public class SalleDeFitness implements CréerOffre, SouscrireOffre, ConsulterChiffreAffaires, ConsulterOffresDisponibles {
    private final Offres offres;
    private final Souscriptions souscriptions;

    public SalleDeFitness(Offres offres, Souscriptions souscriptions) {
        this.offres = offres;
        this.souscriptions = souscriptions;
    }

    @Override
    public void créerOffre(String code, Integer prixEnEuros) {
        offres.créer(code, prixEnEuros);
    }

    @Override
    public void souscrireOffre(String nomClient, String identifiantOffre) {
        souscriptions.ajouter(nomClient, identifiantOffre);
    }

    @Override
    public Integer consulterChiffreDAffaires() {
        return souscriptions.enregistrées()
                .stream()
                .reduce(0, (résultat, souscription) -> résultat + prixOffreLiéeÀ(souscription), Integer::sum);
    }

    private Integer prixOffreLiéeÀ(Souscription souscription) {
        var offreLiéeÀSouscription = offres.disponibles()
                .stream()
                .filter(offre -> offre.identifiant().equals(souscription.identifiantOffre()))
                .findFirst();

        return offreLiéeÀSouscription.map(Offre::prix).orElse(0);
    }

    @Override
    public List<Offre> consulterOffresDisponibles() {
        return offres.disponibles();
    }
}
