package org.pauleliance.domain.ports.userside;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.Souscription;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsulterChiffreAffairesTest {


    private final Offres offres = mock(Offres.class);
    private final Souscriptions souscriptions = mock(Souscriptions.class);
    private final ConsulterChiffreAffaires consulterChiffreAffaires = new SalleDeFitness(offres, souscriptions);

    @Test
    @DisplayName("calcule le chiffre d'affaires en fonction des souscriptions")
    void calculeLeChiffreDAffairesEnFonctionDesSouscriptions() {
        var mensuelle = new Offre("mensuelle_saint_valentin", 40);
        var annuelle = new Offre("annuelle_debut_année", 30);

        List<Souscription> deuxMensuellesEtTroisAnnuelles = List.of(
                new Souscription("Gilles", mensuelle.type()),
                new Souscription("Paul", mensuelle.type()),
                new Souscription("Léo", annuelle.type()),
                new Souscription("Sarah", annuelle.type()),
                new Souscription("Paul-Elian", annuelle.type())
        );

        when(offres.disponibles()).thenReturn(List.of(mensuelle, annuelle));
        when(souscriptions.enregistrées()).thenReturn(deuxMensuellesEtTroisAnnuelles);

        assertThat(consulterChiffreAffaires.exécuter()).isEqualTo(2 * mensuelle.prix() + 3 * annuelle.prix());
    }

}
