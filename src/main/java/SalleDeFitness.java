public class SalleDeFitness implements CréerOffre, SouscrireOffre, ConsulterChiffreAffaires {
    private final Offres offres;

    public SalleDeFitness(Offres offres) {
        this.offres = offres;
    }

    @Override
    public void exécuter(TypeOffre type, Integer prixEnEuros) {
        offres.créer(type, prixEnEuros);
    }
}
