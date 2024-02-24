import java.util.Objects;

public class InterpréteurCommandes {
    private final CréerOffre créerOffre;

    public InterpréteurCommandes(Sortie sortie, CréerOffre créerOffre, SouscrireOffre b, ConsulterChiffreAffaires c) {
        this.créerOffre = créerOffre;
    }

    public void exécuter(String offreCommande) {
        if (!Objects.equals(offreCommande.split(" ")[0], "offre"))
            throw new UnsupportedOperationException("not yet implemented");

        var type = TypeOffre.MENSUELLE;
        var prixParMois = offreCommande.split(" ")[2];
        créerOffre.exécuter(type, Integer.parseInt(prixParMois));
    }
}
