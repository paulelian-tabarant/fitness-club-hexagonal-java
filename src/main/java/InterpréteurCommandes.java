import java.util.Objects;

import static java.lang.Integer.parseInt;

public class InterpréteurCommandes {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public InterpréteurCommandes(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = argumentÀ(offreCommande, 0);

        var interpréteurFactory = new InterpréteurFactory(créerOffre);
        var interpréteur = interpréteurFactory.pour(commande);

        if (isCréerOffre(commande)) {
            interpréteur.interpréter(offreCommande);
            return;
        }

        if (isSouscrireOffre(commande)) {
            var nomPersonne = argumentÀ(offreCommande, 1);
            var identifiantOffre = argumentÀ(offreCommande, 2);
            souscrireOffre.exécuter(nomPersonne, identifiantOffre);
            return;
        }

        throw new UnsupportedOperationException("not yet implemented");
    }

    private static boolean isSouscrireOffre(String commande) {
        return Objects.equals(commande, SOUSCRIRE_OFFRE);
    }

    private static boolean isCréerOffre(String commande) {
        return Objects.equals(commande, CRÉER_OFFRE);
    }

    private static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
