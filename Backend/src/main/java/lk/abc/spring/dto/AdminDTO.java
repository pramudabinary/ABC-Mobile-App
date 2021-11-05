package lk.abc.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDTO {
    private String id;
    private String name;
    private String address;
    private String contact;
    private String email;
    private String password;
}
