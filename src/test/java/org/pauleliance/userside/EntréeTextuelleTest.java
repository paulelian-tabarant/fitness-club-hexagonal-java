package org.pauleliance.userside;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.ports.userside.PourConsulterLesOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterLeChiffreDAffaires;
import org.pauleliance.domain.ports.userside.PourCréerUneOffre;
import org.pauleliance.domain.ports.userside.PourSouscrireÀUneOffre;
import org.pauleliance.domain.ports.userside.Sortie;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

class EntréeTextuelleTest {

    private final PourCréerUneOffre pourCréerUneOffre = mock(PourCréerUneOffre.class);
    private final PourSouscrireÀUneOffre pourSouscrireÀUneOffre = mock(PourSouscrireÀUneOffre.class);

    private final PourConsulterLeChiffreDAffaires pourConsulterLeChiffreDAffaires = mock(PourConsulterLeChiffreDAffaires.class);
    private final PourConsulterLesOffresDisponibles pourConsulterLesOffresDisponibles = mock(PourConsulterLesOffresDisponibles.class);

    private final Sortie sortie = mock(Sortie.class);
    private final EntréeTextuelle entréeTextuelle = new EntréeTextuelle(sortie, pourCréerUneOffre, pourSouscrireÀUneOffre, pourConsulterLeChiffreDAffaires, pourConsulterLesOffresDisponibles);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre annuelle_noel2024 30";

        // quand
        entréeTextuelle.interpréter(créerOffreCommande);

        // on a
        verify(pourCréerUneOffre).créerUneOffre("annuelle_noel2024", 30);
    }

    @Test
    void prendEnCompteLaSouscriptionDUnePersonneAUneOffre() {
        // avec
        String identifiantOffre = "3def4c-30";
        var souscrireOffreCommande = "souscrit Gilles " + identifiantOffre;

        // quand
        entréeTextuelle.interpréter(souscrireOffreCommande);

        // on a
        verify(pourSouscrireÀUneOffre).souscrireÀUneOffre("Gilles", identifiantOffre);
    }

    @Test
    void afficheLeChiffreDAffaires() {
        // avec
        var chiffreDAffairesCommande = "ca";
        when(pourConsulterLeChiffreDAffaires.consulterLeChiffreDAffaires()).thenReturn(30);

        // quand
        entréeTextuelle.interpréter(chiffreDAffairesCommande);

        // on a
        verify(sortie).envoyer("Chiffre d'affaires du mois : 30€");
    }

    @Test
    @DisplayName("affiche les offres disponibles séparées d'un espace")
    void afficheLesOffresDisponiblesSéparéesDUnEspace() {
        var annuelle = new Offre("annuelle_noel2024", 30);
        var mensuelle = new Offre("mensuelle_noel2024", 40);

        when(pourConsulterLesOffresDisponibles.consulterLesOffresDisponibles()).thenReturn(List.of(annuelle, mensuelle));

        entréeTextuelle.interpréter("offres");

        verify(sortie).envoyer(annuelle.code() + " " + mensuelle.code());
    }

    @Test
    @DisplayName("N'envoie rien quand il n'y a pas d'offre")
    void nEnvoieRienQuandIlNYAPasDOffre() {
        when(pourConsulterLesOffresDisponibles.consulterLesOffresDisponibles()).thenReturn(List.of());

        entréeTextuelle.interpréter("offres");

        verify(sortie, never()).envoyer(anyString());
    }

    @Test
    void estEnErreurSiLaCommandeNEstPasReconnue() {
        // avec
        var commandeInconnue = "demande_une_pizza 4 fromages";

        // quand on a
        assertThatThrownBy(() -> entréeTextuelle.interpréter(commandeInconnue))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
