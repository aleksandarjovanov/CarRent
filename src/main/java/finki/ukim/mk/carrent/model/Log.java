package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {

    private Long id;
    private String sessionId;
    private String roll;
    private String userName;
    private LocalTime fromTime;
    private LocalTime toTime;
    private int totalHours;

    public void createLog(String sessionId, String roll, String userName, LocalTime from, LocalTime to, int totalHours){
        this.sessionId = sessionId;
        this.roll = roll;
        this.userName = userName;
        this.fromTime = from;
        this.toTime = to;
        this.totalHours = totalHours; // no no no no, it will need logic !
    }
}
