package lk.abc.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/21/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private String qty;
    private String price;
//    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private MultipartFile image;
}
