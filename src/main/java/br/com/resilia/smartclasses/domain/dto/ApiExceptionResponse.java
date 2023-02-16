package br.com.resilia.smartclasses.domain.dto;

import br.com.resilia.smartclasses.resources.exceptions.ApiException;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {
    private LocalDateTime moment;
    private String message;
    private String errorName;
    private String path;

    public ApiExceptionResponse(ApiException apiException) {
        this.errorName = apiException.getErrorName();
        this.message = apiException.getMessage();
        this.moment = apiException.getMoment();
        this.path = apiException.getPath();
    }
}
