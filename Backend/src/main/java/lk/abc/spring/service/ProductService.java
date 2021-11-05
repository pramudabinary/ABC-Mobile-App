package lk.abc.spring.service;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.ProductDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */
public interface ProductService {
    void addProduct(ProductDTO dto);
    void updateProduct(ProductDTO dto);
    void deleteProduct(String id);
    ArrayList<ProductDTO> getAllProducts();
}
