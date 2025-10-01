package br.senac.sp.appleacademyapi.timelog;

import br.senac.sp.appleacademyapi.student.StudentService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TimeLogService {

    private final TimeLogRepository timeLogRepository;
    private final StudentService studentService;

    @Transactional
    public TimeLog register(@Valid TimeLogRequest request) {
        var student = studentService.getById(request.studentId());
        return timeLogRepository.save(request.toTimeLog(student));
    }

    public Page<TimeLog> listAll(Pageable pageable) {
        return timeLogRepository.findAll(pageable);
    }
}
