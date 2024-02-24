import java.util.Objects;

import static java.lang.Integer.parseInt;

public class InterpréteurCommandes {
    public static final String CRÉER_OFFRE = "offre";
    private final CréerOffre créerOffre;

    public InterpréteurCommandes(Sortie sortie, CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = offreCommande.split(" ")[0];

        if (!Objects.equals(commande, CRÉER_OFFRE)) {
            throw new UnsupportedOperationException("not yet implemented");
        }

        var prixParMois = offreCommande.split(" ")[2];
        créerOffre.exécuter(TypeOffre.MENSUELLE, parseInt(prixParMois));
    }
}
