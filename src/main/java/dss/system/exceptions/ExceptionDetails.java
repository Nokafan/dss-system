package dss.system.exceptions;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionDetails {
    private LocalDateTime timestamp;
    private int status;
    private String message;
    private String details;
}
