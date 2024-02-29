import org.junit.jupiter.api.Test;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.serverside.OffresEnMémoire;
import org.pauleliance.serverside.SouscriptionsEnMémoire;
import org.pauleliance.userside.CommandesInput;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {

    @Test
    // TODO: interagir directement avec l'entrée standard
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        var salle = new SalleDeFitness(new OffresEnMémoire(), new SouscriptionsEnMémoire());
        var sortie = mock(Sortie.class);

        var commandes = new CommandesInput(sortie, salle, salle, salle);

        commandes.exécuter("offre 30");
        // TODO: implémenter 'voir les offres disponibles'
        // TODO: intercepter la valeur de l'identifiant de l'offre envoyé en sortie
        commandes.exécuter("souscrit Gilles mensuelle_30");
        commandes.exécuter("ca");

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
