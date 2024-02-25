import static java.lang.Integer.parseInt;

public class CréerOffreInterpréteur implements Interpréteur {

    private final CréerOffre créerOffre;

    public CréerOffreInterpréteur(CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    @Override
    public void interpréter(String offreCommande) {
        var prixParMois = argumentÀ(offreCommande, 2);
        créerOffre.exécuter(TypeOffre.MENSUELLE, parseInt(prixParMois));
    }

    private static String argumentÀ(String offreCommande, int index) {
        return offreCommande.split(" ")[index];
    }
}
