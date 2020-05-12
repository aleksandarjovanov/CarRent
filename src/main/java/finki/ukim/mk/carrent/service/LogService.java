package finki.ukim.mk.carrent.service;

import finki.ukim.mk.carrent.model.Log;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface LogService {

    Log findById(Long logId);

    Log createLog(String sessionId, String roll, String userName, String ipAddress, boolean isSuccess, String signUpTime, String logOutTime, double totalHours);

    List<Log> getAllLogs();

    void update(Log log);

}
