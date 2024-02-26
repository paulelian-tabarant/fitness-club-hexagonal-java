package org.pauleliance.domain.ports.userside;

import org.pauleliance.domain.TypeOffre;

public interface CréerOffre {
    void exécuter(TypeOffre type, Integer prixEnEuros);
}
