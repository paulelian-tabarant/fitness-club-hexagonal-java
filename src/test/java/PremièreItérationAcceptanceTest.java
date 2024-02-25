import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PremièreItérationAcceptanceTest {

    @Test
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        // TODO: interagir directement avec l'entrée standard

        var créerOffre = "offre mensuelle 30";

        var souscrireOffre = "souscrit";
        var nomPersonne = "Gilles";
        var identifiantOffre = "mensuelle_30";
        var consulterChiffreAffairesMensuel = "ca";

        var salle = new SalleDeFitness(new OffresEnMémoire());
        var sortie = mock(Sortie.class);
        var commandes = new InterpréteurCommandes(sortie, salle, salle);

        commandes.exécuter(créerOffre);
        commandes.exécuter(souscrireOffre + " " + nomPersonne + " " + identifiantOffre);
        commandes.exécuter(consulterChiffreAffairesMensuel);

        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

}
