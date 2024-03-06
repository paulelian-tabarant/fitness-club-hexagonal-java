package org.pauleliance;

import org.junit.jupiter.api.Test;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.serverside.OffresEnMémoire;
import org.pauleliance.serverside.SouscriptionsEnMémoire;
import org.pauleliance.userside.EntréeTextuelle;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {
    SalleDeFitness salle = new SalleDeFitness(new OffresEnMémoire(), new SouscriptionsEnMémoire());
    Sortie sortie = mock(Sortie.class);

    @Test
    // TODO: interagir directement avec l'entrée standard
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        var entrée = new EntréeTextuelle(sortie, salle, salle, salle, salle);

        entrée.exécuter("offre annuelle_noel2024 30");
        entrée.exécuter("offres");

        verify(sortie).envoyer("annuelle_noel2024");

        entrée.exécuter("souscrit Gilles annuelle_noel2024");
        // TODO: implémenter la partie server-side des souscriptions
        entrée.exécuter("ca");

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
