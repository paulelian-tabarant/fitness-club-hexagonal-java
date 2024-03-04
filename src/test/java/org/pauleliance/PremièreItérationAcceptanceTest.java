package org.pauleliance;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.serverside.OffresEnMémoire;
import org.pauleliance.serverside.SouscriptionsEnMémoire;
import org.pauleliance.userside.CommandesInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {
    SalleDeFitness salle = new SalleDeFitness(new OffresEnMémoire(), new SouscriptionsEnMémoire());
    Sortie sortie = mock(Sortie.class);

    @Test
    // TODO: interagir directement avec l'entrée standard
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        var commandes = new CommandesInput(sortie, salle, salle, salle, salle);

        commandes.exécuter("offre annuelle_noel2024 30");
        commandes.exécuter("offres");

        verify(sortie).envoyer("annuelle_noel2024");

        commandes.exécuter("souscrit Gilles annuelle_noel2024");
        // TODO: implémenter la partie server-side des souscriptions
        commandes.exécuter("ca");

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
