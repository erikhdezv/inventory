package co.com.erikdhv.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Long id;
    private String name;
    private Integer age;
    private Integer roleId;
    private LocalDate admissionDate;
}
