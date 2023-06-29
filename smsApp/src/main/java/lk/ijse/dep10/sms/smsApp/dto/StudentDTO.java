package lk.ijse.dep10.sms.smsApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {

    private int id;
    @NotBlank(message = "Student name cant be Empty")
    private String name;
    @NotBlank(message = "Student address cant be Empty")
    private String address;

    public StudentDTO(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
