public class CommandesInput {
    private final CréerOffre créerOffre;
    private final SouscrireOffre souscrireOffre;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre) {
        this.créerOffre = créerOffre;
        this.souscrireOffre = souscrireOffre;
    }

    public void exécuter(String offreCommande) {
        String commande = Interpréteur.argumentÀ(offreCommande, 0);

        new InterpréteurFactory(créerOffre, souscrireOffre).pour(commande)
                .interpréter(offreCommande);
    }
}
