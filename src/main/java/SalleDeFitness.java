public class SalleDeFitness implements CréerOffre, SouscrireOffre, ConsulterChiffreAffaires {
    private final Offres offres;

    public SalleDeFitness(Offres offres, Souscriptions souscriptions) {
        this.offres = offres;
    }

    @Override
    public void exécuter(TypeOffre type, Integer prixEnEuros) {
        offres.créer(type, prixEnEuros);
    }

    @Override
    public void exécuter(String gilles, String mensuelle30) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
