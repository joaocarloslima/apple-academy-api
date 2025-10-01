package br.senac.sp.appleacademyapi.student;

import java.util.List;
import java.util.UUID;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.senac.sp.appleacademyapi.mentor.MentorResponse;
import br.senac.sp.appleacademyapi.security.AuthUserRepository;
import jakarta.validation.Valid;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final AuthUserRepository authUserRepository;

    private final PasswordEncoder passwordEncoder;
    private final StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    @Transactional
    public StudentResponse create(StudentRequest studentRequest) {
        var student = repository.save(studentRequest.toStudent());
        var authUser = studentRequest.toAuthUser(student.getId());
        authUser.setPassword(passwordEncoder.encode(authUser.getPassword()));
        authUserRepository.save(authUser);
        return StudentResponse.from(student, authUser);
    }

    public Student getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));
    }
    
}
