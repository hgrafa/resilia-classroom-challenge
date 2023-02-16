package br.com.resilia.smartclasses.services.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class ApiException extends RuntimeException {
    private HttpStatus status;
    private LocalDateTime moment;
    private String message;
    private String errorName;
    private String path;

}
