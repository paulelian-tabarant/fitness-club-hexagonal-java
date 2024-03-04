package org.pauleliance.domain.ports;

import org.pauleliance.domain.Offre;

import java.util.List;

public interface ConsulterOffresDisponibles {
    List<Offre> consulterOffresDisponibles();
}
