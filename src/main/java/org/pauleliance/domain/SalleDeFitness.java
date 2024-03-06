package org.pauleliance.domain;

import org.pauleliance.domain.ports.userside.PourConsulterLesOffresDisponibles;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;
import org.pauleliance.domain.ports.userside.PourConsulterLeChiffreDAffaires;
import org.pauleliance.domain.ports.userside.PourCréerUneOffre;
import org.pauleliance.domain.ports.userside.PourSouscrireÀUneOffre;

import java.util.List;

public class SalleDeFitness implements PourCréerUneOffre, PourSouscrireÀUneOffre, PourConsulterLeChiffreDAffaires, PourConsulterLesOffresDisponibles {
    private final Offres offres;
    private final Souscriptions souscriptions;

    public SalleDeFitness(Offres offres, Souscriptions souscriptions) {
        this.offres = offres;
        this.souscriptions = souscriptions;
    }

    @Override
    public void créerUneOffre(String code, Integer prixEnEuros) {
        offres.créer(code, prixEnEuros);
    }

    @Override
    public List<Offre> consulterLesOffresDisponibles() {
        return offres.disponibles();
    }

    @Override
    public void souscrireÀUneOffre(String nomClient, String identifiantOffre) {
        souscriptions.ajouter(nomClient, identifiantOffre);
    }

    @Override
    public Integer consulterLeChiffreDAffaires() {
        return souscriptions.enregistrées()
                .stream()
                .reduce(0, (résultat, souscription) -> résultat + prixOffreLiéeÀ(souscription), Integer::sum);
    }

    private Integer prixOffreLiéeÀ(Souscription souscription) {
        var offreLiéeÀSouscription = offres.disponibles()
                .stream()
                .filter(offre -> offre.code().equals(souscription.identifiantOffre()))
                .findFirst();

        return offreLiéeÀSouscription.map(Offre::prix).orElse(0);
    }
}
