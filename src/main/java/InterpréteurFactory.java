import java.util.Objects;

public class InterpréteurFactory {
    public static final String CRÉER_OFFRE = "offre";
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public InterpréteurFactory(CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public Interpréteur pour(String commande) {
        if (isCréerOffre(commande)) {
            return new CréerOffreInterpréteur(créerOffre);
        }

        return new SouscrireOffreInterpréteur(souscrireOffre);
    }

    private static boolean isCréerOffre(String commande) {
        return Objects.equals(commande, CRÉER_OFFRE);
    }
}
