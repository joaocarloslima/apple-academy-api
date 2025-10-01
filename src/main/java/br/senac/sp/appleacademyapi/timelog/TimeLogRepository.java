package br.senac.sp.appleacademyapi.timelog;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TimeLogRepository extends JpaRepository<TimeLog, UUID> {
}
