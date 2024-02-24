import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class InterpréteurCommandesTest {

    @Test
    void créeUneOffre() {
        // given
        var créerOffre = "offre mensuelle 30";

        var créerOffreCommande = mock(CréerOffre.class);
        var souscrireOffre = mock(SouscrireOffre.class);
        var consulterCA = mock(ConsulterChiffreAffairesMensuel.class);

        // when
        var interpréteur = new InterpréteurCommandes(créerOffreCommande, souscrireOffre, consulterCA);
        interpréteur.exécuter(créerOffre);

        // then
        verify(créerOffreCommande).exécuter(TypeOffre.MENSUELLE, 30);
    }

    @Test
    void renvoieUneErreurSiTypeOffreNonPrisEnCharge() {
        var créerOffre = "offre semestrielle 20";

        // vérifier que la commande "CréerOffre" renvoie une exception métier adaptée
    }
}
