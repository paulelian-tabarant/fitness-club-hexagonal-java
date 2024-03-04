package org.pauleliance.domain.ports;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsulterOffresDisponiblesTest {

    private Offres offres = mock(Offres.class);

    private ConsulterOffresDisponibles consulterOffresDisponibles = new SalleDeFitness(
            offres,
            mock(Souscriptions.class)
    );

    @Test
    @DisplayName("Donne les identifiants des offres enregistrées")
    void donneLesIdentifiantsDesOffresEnregistrées() {
        String offreAnnuelle = "annuelle_noel2024";
        String offreMensuelle = "mensuelle_noel2024";

        when(offres.disponibles()).thenReturn(List.of(
                new Offre(offreAnnuelle, 30),
                new Offre(offreMensuelle, 40)
        ));

        assertThat(consulterOffresDisponibles.consulterOffresDisponibles()).isEqualTo(
                List.of(offreAnnuelle, offreMensuelle)
        );
    }
}
