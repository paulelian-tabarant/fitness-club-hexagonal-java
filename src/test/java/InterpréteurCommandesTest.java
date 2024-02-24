import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InterpréteurCommandesTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final Sortie sortie = mock(Sortie.class);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre mensuelle 30";

        // quand
        new InterpréteurCommandes(sortie, créerOffre).exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).exécuter(TypeOffre.MENSUELLE, 30);
    }

    @Test
    void renvoieUneErreurSiTypeOffreNonPrisEnCharge() {
        var créerOffreInconnueCommande = "offre semestrielle 20";

        // vérifier que la commande "CréerOffre" renvoie une exception métier adaptée
        assertThrows(OffreInconnueException.class, () -> {
            new InterpréteurCommandes(sortie, créerOffre).exécuter(créerOffreInconnueCommande);
        });
    }
}
