import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {

    @Test
    // TODO: interagir directement avec l'entrée standard
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        var salle = new SalleDeFitness(new OffresEnMémoire(), new SouscriptionsEnMémoire());
        var sortie = mock(Sortie.class);

        var commandes = new CommandesInput(sortie, salle, salle);

        commandes.exécuter("offre mensuelle 30");
        commandes.exécuter("souscrit Gilles mensuelle_30");
        commandes.exécuter("ca");

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
