import org.junit.jupiter.api.Test;
import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.userside.CommandesInput;
import org.pauleliance.domain.ports.userside.Sortie;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

class CommandesInputTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);
    private final Sortie sortie = mock(Sortie.class);

    private final ConsulterChiffreAffaires consulterChiffreAffaires = mock(ConsulterChiffreAffaires.class);
    private final CommandesInput commandesInput = new CommandesInput(sortie, créerOffre, souscrireOffre, consulterChiffreAffaires);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre 30";

        // quand
        commandesInput.exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).exécuter(30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        String identifiantOffre = "3def4c-30";
        var souscrireOffreCommande = "souscrit Gilles " + identifiantOffre;

        // quand
        commandesInput.exécuter(souscrireOffreCommande);

        // on a
        verify(souscrireOffre).exécuter("Gilles", identifiantOffre);
    }

    @Test
    void afficheLeChiffreDAffaires() {
        // avec
        var chiffreDAffairesCommande = "ca";
        when(consulterChiffreAffaires.exécuter()).thenReturn(30);

        // quand
        commandesInput.exécuter(chiffreDAffairesCommande);

        // on a
        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

    @Test
    void estEnErreurSiLaCommandeNEstPasReconnue() {
        // avec
        var commandeInconnue = "demande_une_pizza 4 fromages";

        // quand on a
        assertThatThrownBy(() -> commandesInput.exécuter(commandeInconnue))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
