import org.junit.jupiter.api.Test;

class InterpréteurCommandesTest {

    @Test
    void créeUneOffre() {
        var créerOffre = "offre mensuelle 30";

        // vérifier que la commande "CréerOffre" est appelée avec un type 'mensuel' et un prix de base de 30 euros
    }

    @Test
    void renvoieUneErreurSiTypeOffreNonPrisEnCharge() {
        var créerOffre = "offre semestrielle 20";

        // vérifier que la commande "CréerOffre" renvoie une exception métier adaptée
    }
}
