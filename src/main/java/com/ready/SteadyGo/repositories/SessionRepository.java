package com.ready.SteadyGo.repositories;

import com.ready.SteadyGo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
