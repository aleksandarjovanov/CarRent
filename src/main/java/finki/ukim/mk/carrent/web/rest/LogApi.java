package finki.ukim.mk.carrent.web.rest;

import finki.ukim.mk.carrent.model.Log;
import finki.ukim.mk.carrent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/logs")
public class LogApi {

    @Autowired
    private LogService logService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<Log> getLogs() {
        return this.logService.getAllLogs();
    }

}
