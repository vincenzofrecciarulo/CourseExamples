package org.generation.italy.examples.introarchitecture.abstractfactory;

import jakarta.persistence.EntityManager;

public interface EntityManagerProvider {
    EntityManager currentEntityManager();
}
