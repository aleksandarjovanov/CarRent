package finki.ukim.mk.carrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {

    private Long id;
    private String sessionId;
    private String roll;
    private String userName;
    private LocalDateTime from;
    private LocalDateTime tol;
    private int totalHours;
}
