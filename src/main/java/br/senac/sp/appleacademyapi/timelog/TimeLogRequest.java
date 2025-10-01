package br.senac.sp.appleacademyapi.timelog;

import br.senac.sp.appleacademyapi.student.Student;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.UUID;

public record TimeLogRequest(
    @NotNull Double latitude,
    @NotNull Double longitude,
    @NotNull UUID studentId
) {
    public TimeLog toTimeLog(Student student) {
        return new TimeLog(
            null,
                LocalDate.now(),
                LocalTime.now(),
                latitude,
                longitude,
                student,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }
}
