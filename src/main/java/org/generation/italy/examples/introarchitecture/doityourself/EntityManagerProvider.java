package org.generation.italy.examples.introarchitecture.doityourself;

import jakarta.persistence.EntityManager;

public interface EntityManagerProvider {
    EntityManager currentEntityManager();
}
