import org.junit.jupiter.api.Test;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.TypeOffre;
import org.pauleliance.userside.CommandesInput;
import org.pauleliance.domain.ports.userside.Sortie;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class CommandesInputTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);
    private final Sortie sortie = mock(Sortie.class);

    private final CommandesInput commandesInput = new CommandesInput(sortie, créerOffre, souscrireOffre);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre mensuelle 30";

        // quand
        commandesInput.exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).exécuter(TypeOffre.MENSUELLE, 30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        var souscrireOffreCommande = "souscrit Gilles mensuelle_30";

        // quand
        commandesInput.exécuter(souscrireOffreCommande);

        // on a
        verify(souscrireOffre).exécuter("Gilles", "mensuelle_30");
    }
}
