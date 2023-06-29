package lk.ijse.dep10.sms.smsApp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDTO {
    private int id;
    private String name;
    private String address;
}
