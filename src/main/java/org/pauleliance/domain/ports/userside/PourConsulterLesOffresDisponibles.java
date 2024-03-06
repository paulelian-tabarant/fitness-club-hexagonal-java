package org.pauleliance.domain.ports.userside;

import org.pauleliance.domain.Offre;

import java.util.List;

public interface PourConsulterLesOffresDisponibles {
    List<Offre> consulterLesOffresDisponibles();
}
