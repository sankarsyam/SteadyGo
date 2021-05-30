package com.ready.SteadyGo.repositories;

import com.ready.SteadyGo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
