import org.junit.jupiter.api.Test;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.serverside.Souscriptions;
import org.pauleliance.domain.TypeOffre;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CréerOffreTest {

    @Test
    void créeUneOffre() {
        // avec
        var offres = mock(Offres.class);
        var souscriptions = mock(Souscriptions.class);

        // quand
        new SalleDeFitness(offres, souscriptions).exécuter(TypeOffre.MENSUELLE, 30);

        // alors
        verify(offres).créer(TypeOffre.MENSUELLE, 30);
    }

}
