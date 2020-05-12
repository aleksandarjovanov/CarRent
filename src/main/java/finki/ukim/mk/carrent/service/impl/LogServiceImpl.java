package finki.ukim.mk.carrent.service.impl;

import finki.ukim.mk.carrent.model.Log;
import finki.ukim.mk.carrent.model.exceptions.InvalidLogException;
import finki.ukim.mk.carrent.repository.repoInterfaces.LogRepository;
import finki.ukim.mk.carrent.service.LogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    private LogRepository logRepository;

    public LogServiceImpl(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Override
    public Log findById(Long logId) {
        return logRepository.findById(logId).orElseThrow(InvalidLogException::new);
    }

    @Override
    public Log createLog(String sessionId, String roll, String userName, String ipAddress, boolean isSuccess, String signUpTime, String logOutTime, double totalHours) {

        Log log = new Log();
        log.createLog(sessionId, roll, userName, ipAddress, isSuccess, signUpTime, logOutTime, totalHours);

        return logRepository.save(log);
    }

    @Override
    public void update(Log log) {
        logRepository.save(log);
    }

    @Override
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }
}
