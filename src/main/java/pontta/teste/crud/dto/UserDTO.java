package pontta.teste.crud.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UserDTO(

        Long id,
        String name,
        String email,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        LocalDate dateOfBirth

) {
}
