package org.pauleliance.userside;

import org.pauleliance.domain.ports.ConsulterOffresDisponibles;
import org.pauleliance.domain.ports.userside.Sortie;

public class ConsulterOffresDisponiblesInterpréteur implements Interpréteur {

    private final ConsulterOffresDisponibles consulterOffresDisponibles;
    private final Sortie sortie;

    ConsulterOffresDisponiblesInterpréteur(ConsulterOffresDisponibles consulterOffresDisponibles, Sortie sortie) {
        this.consulterOffresDisponibles = consulterOffresDisponibles;
        this.sortie = sortie;
    }

    @Override
    public void interpréter(String instruction) {
        var offres = consulterOffresDisponibles.consulterOffresDisponibles();
        sortie.envoyer(String.join(" ", offres));
    }
}
