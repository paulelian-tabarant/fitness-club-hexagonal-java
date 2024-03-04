package org.pauleliance;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.serverside.OffresEnMémoire;
import org.pauleliance.serverside.SouscriptionsEnMémoire;
import org.pauleliance.userside.CommandesInput;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {

    ArgumentCaptor<String> offresCaptor;

    @Test
    // TODO: interagir directement avec l'entrée standard
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        var salle = new SalleDeFitness(new OffresEnMémoire(), new SouscriptionsEnMémoire());
        var sortie = mock(Sortie.class);

        var commandes = new CommandesInput(sortie, salle, salle, salle, salle);

        commandes.exécuter("offre 30");
        commandes.exécuter("offres");

        verify(sortie).envoyer(offresCaptor.capture());
        assertThat(offresCaptor.getValue().split(" ")).hasSize(1);

        var premièreOffre = offresCaptor.getValue();

        commandes.exécuter("souscrit Gilles " + premièreOffre);
        // TODO: implémenter la partie server-side des souscriptions
        commandes.exécuter("ca");

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
