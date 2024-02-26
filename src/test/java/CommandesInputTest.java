import org.junit.jupiter.api.Test;
import org.pauleliance.domain.CréerOffre;
import org.pauleliance.domain.SouscrireOffre;
import org.pauleliance.domain.TypeOffre;
import org.pauleliance.userside.CommandesInput;
import org.pauleliance.domain.Sortie;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CommandesInputTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);
    private final Sortie sortie = mock(Sortie.class);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre mensuelle 30";

        // quand
        new CommandesInput(sortie, créerOffre, souscrireOffre).exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).exécuter(TypeOffre.MENSUELLE, 30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        var souscrireOffreCommande = "souscrit Gilles mensuelle_30";

        // quand
        new CommandesInput(sortie, créerOffre, souscrireOffre).exécuter(souscrireOffreCommande);

        // on a
        verify(souscrireOffre).exécuter("Gilles", "mensuelle_30");
    }
}
