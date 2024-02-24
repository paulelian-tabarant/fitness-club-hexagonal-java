import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstIterationAcceptanceTest {

    @Test
    void afficheChiffreAffairesAprèsCréationOffreEtSouscription() {
        // TODO: interagir directement avec l'entrée standard

        var créerOffre = "offre mensuelle 30";
        var identifiantOffre = "mensuelle_30";
        var souscrireOffre = "toto souscrit";
        var consulterChiffreAffairesMensuel = "ca";

        var salle = new SalleDeFitness();
        var commandes = new InterpréteurCommandes(salle, salle, salle);

        commandes.exécuter(créerOffre);
        commandes.exécuter(souscrireOffre + " " + identifiantOffre);

        assertEquals("30€", commandes.exécuter(consulterChiffreAffairesMensuel));
    }

}
