import static java.lang.Integer.parseInt;

public class CommandesInput {
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = argumentÀ(offreCommande, 0);

        var interpréteur = new InterpréteurFactory(créerOffre, souscrireOffre).pour(commande);

        interpréteur.interpréter(offreCommande);
    }

    private static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
