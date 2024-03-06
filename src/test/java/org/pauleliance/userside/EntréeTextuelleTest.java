package org.pauleliance.userside;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.SouscrireOffre;
import org.pauleliance.domain.ports.userside.Sortie;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class EntréeTextuelleTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);

    private final PourConsulterChiffreAffaires pourConsulterChiffreAffaires = mock(PourConsulterChiffreAffaires.class);
    private final ConsulterOffresDisponibles consulterOffresDisponibles = mock(ConsulterOffresDisponibles.class);

    private final Sortie sortie = mock(Sortie.class);
    private final EntréeTextuelle entréeTextuelle = new EntréeTextuelle(sortie, créerOffre, souscrireOffre, pourConsulterChiffreAffaires, consulterOffresDisponibles);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre annuelle_noel2024 30";

        // quand
        entréeTextuelle.exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).créerOffre("annuelle_noel2024", 30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        String identifiantOffre = "3def4c-30";
        var souscrireOffreCommande = "souscrit Gilles " + identifiantOffre;

        // quand
        entréeTextuelle.exécuter(souscrireOffreCommande);

        // on a
        verify(souscrireOffre).souscrireOffre("Gilles", identifiantOffre);
    }

    @Test
    void afficheLeChiffreDAffaires() {
        // avec
        var chiffreDAffairesCommande = "ca";
        when(pourConsulterChiffreAffaires.consulterChiffreAffaires()).thenReturn(30);

        // quand
        entréeTextuelle.exécuter(chiffreDAffairesCommande);

        // on a
        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

    @Test
    @DisplayName("affiche les offres disponibles séparées d'un espace")
    void afficheLesOffresDisponiblesSéparéesDUnEspace() {
        var annuelle = new Offre("annuelle_noel2024", 30);
        var mensuelle = new Offre("mensuelle_noel2024", 40);

        when(consulterOffresDisponibles.consulterOffresDisponibles()).thenReturn(List.of(annuelle, mensuelle));

        entréeTextuelle.exécuter("offres");

        verify(sortie).envoyer(annuelle.code() + " " + mensuelle.code());
    }

    @Test
    @DisplayName("N'envoie rien quand il n'y a pas d'offre")
    void nEnvoieRienQuandIlNYAPasDOffre() {
        when(consulterOffresDisponibles.consulterOffresDisponibles()).thenReturn(List.of());

        entréeTextuelle.exécuter("offres");

        verify(sortie, never()).envoyer(anyString());
    }

    @Test
    void estEnErreurSiLaCommandeNEstPasReconnue() {
        // avec
        var commandeInconnue = "demande_une_pizza 4 fromages";

        // quand on a
        assertThatThrownBy(() -> entréeTextuelle.exécuter(commandeInconnue))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
