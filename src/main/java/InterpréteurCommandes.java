import java.util.Objects;

import static java.lang.Integer.parseInt;

public class InterpréteurCommandes {
    public static final String CRÉER_OFFRE = "offre";
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public InterpréteurCommandes(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = offreCommande.split(" ")[0];

        if (Objects.equals(commande, CRÉER_OFFRE)) {
            var prixParMois = offreCommande.split(" ")[2];
            créerOffre.exécuter(TypeOffre.MENSUELLE, parseInt(prixParMois));
            return;
        }

        if (Objects.equals(commande, "souscrit")) {
            var nom = offreCommande.split(" ")[1];
            var identifiantOffre = offreCommande.split(" ")[2];
            souscrireOffre.exécuter(nom, identifiantOffre);
            return;
        }

        throw new UnsupportedOperationException("not yet implemented");
    }
}
