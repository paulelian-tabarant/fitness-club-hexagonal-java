import java.util.Objects;

import static java.lang.Integer.parseInt;

public class CommandesInput {
    public static final String CRÉER_OFFRE = "offre";
    public static final String SOUSCRIRE_OFFRE = "souscrit";
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = argumentÀ(offreCommande, 0);

        var interpréteurFactory = new InterpréteurFactory(créerOffre, souscrireOffre);
        var interpréteur = interpréteurFactory.pour(commande);

        if (isCréerOffre(commande)) {
            interpréteur.interpréter(offreCommande);
            return;
        }

        if (isSouscrireOffre(commande)) {
            interpréteur.interpréter(offreCommande);
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
