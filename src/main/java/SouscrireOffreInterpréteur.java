public class SouscrireOffreInterpréteur implements Interpréteur {
    private final SouscrireOffre souscrireOffre;

    public SouscrireOffreInterpréteur(SouscrireOffre souscrireOffre) {
        this.souscrireOffre = souscrireOffre;
    }

    @Override
    public void interpréter(String offreCommande) {
        var nomPersonne = argumentÀ(offreCommande, 1);
        var identifiantOffre = argumentÀ(offreCommande, 2);

        souscrireOffre.exécuter(nomPersonne, identifiantOffre);
    }

    private static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
