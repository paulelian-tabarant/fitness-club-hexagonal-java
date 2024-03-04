package org.pauleliance.userside;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.Sortie;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class CommandesInputTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);

    private final ConsulterChiffreAffaires consulterChiffreAffaires = mock(ConsulterChiffreAffaires.class);
    private final ConsulterOffresDisponibles consulterOffresDisponibles = mock(ConsulterOffresDisponibles.class);

    private final Sortie sortie = mock(Sortie.class);
    private final CommandesInput commandesInput = new CommandesInput(sortie, créerOffre, souscrireOffre, consulterChiffreAffaires, consulterOffresDisponibles);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre 30";

        // quand
        commandesInput.exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).créerOffre(30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        String identifiantOffre = "3def4c-30";
        var souscrireOffreCommande = "souscrit Gilles " + identifiantOffre;

        // quand
        commandesInput.exécuter(souscrireOffreCommande);

        // on a
        verify(souscrireOffre).souscrireOffre("Gilles", identifiantOffre);
    }

    @Test
    void afficheLeChiffreDAffaires() {
        // avec
        var chiffreDAffairesCommande = "ca";
        when(consulterChiffreAffaires.consulterChiffreDAffaires()).thenReturn(30);

        // quand
        commandesInput.exécuter(chiffreDAffairesCommande);

        // on a
        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

    @Test
    @DisplayName("affiche les offres disponibles séparées d'un espace")
    void afficheLesOffresDisponiblesSéparéesDUnEspace() {
        String offreAnnuelle = "annuelle_noel2024";
        String offreMensuelle = "mensuelle_noel2024";

        when(consulterOffresDisponibles.consulterOffresDisponibles()).thenReturn(List.of(offreAnnuelle, offreMensuelle));

        commandesInput.exécuter("offres");

        verify(sortie).envoyer(offreAnnuelle + " " + offreMensuelle);
    }

    @Test
    @Disabled
    @DisplayName("N'envoie rien quand il n'y a pas d'offre")
    void nEnvoieRienQuandIlNYAPasDOffre() {
        String offreAnnuelle = "annuelle_noel2024";
        String offreMensuelle = "mensuelle_noel2024";

        when(consulterOffresDisponibles.consulterOffresDisponibles()).thenReturn(List.of(offreAnnuelle, offreMensuelle));

        commandesInput.exécuter("offres");

        verify(sortie).envoyer(offreAnnuelle + " " + offreMensuelle);
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
