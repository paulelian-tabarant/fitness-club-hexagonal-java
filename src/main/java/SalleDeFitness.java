import javax.naming.OperationNotSupportedException;

public class SalleDeFitness implements CréerOffre, SouscrireOffre, ConsulterChiffreAffairesMensuel {
    @Override
    public void exécuter(TypeOffre typeOffre, int i) {
        throw new UnsupportedOperationException("not yet implemented");
    }
}
