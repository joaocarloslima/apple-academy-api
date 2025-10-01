package br.senac.sp.appleacademyapi.timelog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timelog")
@RequiredArgsConstructor
public class TimeLogController {

    private final TimeLogService timeLogService;

    @PostMapping
    public TimeLog register(@Valid @RequestBody TimeLogRequest request){
        return timeLogService.register(request);
    }

    @GetMapping
    public Page<TimeLog> list(Pageable pageable){
        return timeLogService.listAll(pageable);
    }

}
