package org.pauleliance.serverside;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.pauleliance.domain.Offre;
import org.pauleliance.domain.OffreExisteDéjàException;
import org.pauleliance.domain.ports.serverside.Offres;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OffresTest {

    private final Offres offres = new OffresEnMémoire();

    @Test
    @DisplayName("stocke les offres créées")
    void stockeLesOffresCréées() {
        Offre mensuelle = new Offre("mensuelle_noel2024", 40);
        Offre annuelle = new Offre("annuelle_noel2024", 30);

        offres.créer(mensuelle.code(), mensuelle.prix());
        offres.créer(annuelle.code(), annuelle.prix());

        assertThat(offres.disponibles()).isEqualTo(List.of(mensuelle, annuelle));
    }

    @Test
    @DisplayName("est en erreur quand l'offre existe déjà")
    void estEnErreurQuandLOffreExisteDéjà() {
        String codeQuiExisteDéjà = "annuelle_noel2024";
        Integer unPrix = 30;

        offres.créer(codeQuiExisteDéjà, unPrix);

        assertThrows(OffreExisteDéjàException.class, () -> {
            offres.créer(codeQuiExisteDéjà, unPrix);
        });
    }
}
