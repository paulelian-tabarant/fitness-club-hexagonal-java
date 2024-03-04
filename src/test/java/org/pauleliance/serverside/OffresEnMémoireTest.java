package org.pauleliance.serverside;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class OffresEnMémoireTest {

    private final OffresEnMémoire offres = new OffresEnMémoire();

    @Test
    @DisplayName("stocke les offres créées")
    void stockeLesOffresCréées() {
        Offre mensuelle = new Offre("mensuelle_noel2024", 40);
        Offre annuelle = new Offre("annuelle_noel2024", 30);

        offres.créer(mensuelle.identifiant(), mensuelle.prix());
        offres.créer(annuelle.identifiant(), annuelle.prix());

        assertThat(offres.disponibles()).isEqualTo(List.of(mensuelle, annuelle));
    }
}
