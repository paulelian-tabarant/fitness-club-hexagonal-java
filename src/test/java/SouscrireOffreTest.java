import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class SouscrireOffreTest {

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        var nomPersonne = "Gilles";
        var identifiantOffre = "mensuelle_30";
        var souscriptions = mock(Souscriptions.class);

        // quand
        new SalleDeFitness(mock(Offres.class), souscriptions).exécuter(nomPersonne, identifiantOffre);

        // alors
        verify(souscriptions).ajouter(nomPersonne, identifiantOffre);
    }

}

