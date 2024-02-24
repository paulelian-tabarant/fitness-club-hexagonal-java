import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InterpréteurCommandesTest {

    private final CréerOffre créerOffre = mock(CréerOffre.class);
    private final SouscrireOffre souscrireOffre = mock(SouscrireOffre.class);
    private final ConsulterChiffreAffaires consulterCA = mock(ConsulterChiffreAffaires .class);
    private final Sortie sortie = mock(Sortie.class);

    @Test
    void créeUneOffre() {
        // avec
        var créerOffreCommande = "offre mensuelle 30";

        // quand
        new InterpréteurCommandes(sortie, créerOffre, souscrireOffre, consulterCA)
                .exécuter(créerOffreCommande);

        // on a
        verify(créerOffre).exécuter(TypeOffre.MENSUELLE, 30);
    }

    @Test
    void renvoieUneErreurSiTypeOffreNonPrisEnCharge() {
        var créerOffre = "offre semestrielle 20";

        // vérifier que la commande "CréerOffre" renvoie une exception métier adaptée
    }
}
