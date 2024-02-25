public class InterpréteurFactory {
    private final CréerOffre créerOffre;

    public InterpréteurFactory(CréerOffre créerOffre) {
        this.créerOffre = créerOffre;
    }

    public Interpréteur pour(String commande) {
        return new CréerOffreInterpréteur(créerOffre);
    }
}
