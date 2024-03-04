package org.pauleliance.domain;

public class OffreExisteDéjàException extends RuntimeException {
    public OffreExisteDéjàException(Offre offre) {
        super("L'offre " + offre.code() + " existe déjà.");
    }
}
