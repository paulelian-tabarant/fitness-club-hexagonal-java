package org.pauleliance.userside;

import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.PourConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class EntréeTextuelle {

    private final CommandeTextuelleFactory commandeTextuelleFactory;

    public EntréeTextuelle(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre, PourConsulterChiffreAffaires pourConsulterChiffreAffaires, ConsulterOffresDisponibles consulterOffresDisponibles) {
        commandeTextuelleFactory = new CommandeTextuelleFactory(créerOffre, souscrireOffre, pourConsulterChiffreAffaires, consulterOffresDisponibles, sortie);
    }

    public void exécuter(String instruction) {
        String nomCommande = CommandeTextuelle.argumentÀ(instruction, 0);

        commandeTextuelleFactory.pour(nomCommande).exécuter(instruction);
    }
}
