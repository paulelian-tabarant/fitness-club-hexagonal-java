package org.pauleliance.domain.ports.userside;

import org.junit.jupiter.api.Test;
import org.pauleliance.domain.SalleDeFitness;
import org.pauleliance.domain.ports.serverside.Offres;
import org.pauleliance.domain.ports.serverside.Souscriptions;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PourCréerUneOffreTest {

    @Test
    void créeUneOffre() {
        // avec
        var offres = mock(Offres.class);
        var souscriptions = mock(Souscriptions.class);

        // quand
        new SalleDeFitness(offres, souscriptions).créerUneOffre("annuelle_noel2024", 30);

        // alors
        verify(offres).créer("annuelle_noel2024", 30);
    }

}
