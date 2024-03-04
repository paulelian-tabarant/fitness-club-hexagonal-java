package org.pauleliance.domain.ports;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsulterOffresDisponiblesTest {

    private final Offres offres = mock(Offres.class);

    private final ConsulterOffresDisponibles consulterOffresDisponibles =
            new SalleDeFitness(offres, mock(Souscriptions.class));

    @Test
    @DisplayName("Donne les offres enregistrées")
    void donneLesOffresEnregistrées() {
        Offre offreAnnuelle = new Offre("annuelle_noel2024", 30);
        Offre offreMensuelle = new Offre("mensuelle_noel2024", 40);

        when(offres.disponibles()).thenReturn(List.of(offreAnnuelle, offreMensuelle));

        assertThat(consulterOffresDisponibles.consulterOffresDisponibles()).isEqualTo(
                List.of(offreAnnuelle, offreMensuelle)
        );
    }
}
