package org.pauleliance.userside;

import org.pauleliance.domain.ports.userside.ConsulterChiffreAffaires;
import org.pauleliance.domain.ports.userside.CréerOffre;
import org.pauleliance.domain.ports.userside.Sortie;
import org.pauleliance.domain.ports.userside.SouscrireOffre;

public class CommandesInput {

    private final InterpréteurFactory interpréteur;

    public CommandesInput(Sortie sortie, CréerOffre créerOffre, SouscrireOffre souscrireOffre, ConsulterChiffreAffaires consulterChiffreAffaires) {
        interpréteur = new InterpréteurFactory(créerOffre, souscrireOffre, consulterChiffreAffaires, sortie);
    }

    public void exécuter(String commandeEtArguments) {
        String commande = Interpréteur.argumentÀ(commandeEtArguments, 0);

        interpréteur.pour(commande).lancer(commandeEtArguments);
    }
}
