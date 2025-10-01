package br.senac.sp.appleacademyapi.timelog;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timelog")
@RequiredArgsConstructor
public class TimeLogController {

    private final TimeLogService timeLogService;

    @PostMapping
    public TimeLog register(@Valid @RequestBody TimeLogRequest request){
        return timeLogService.register(request);
    }

}
