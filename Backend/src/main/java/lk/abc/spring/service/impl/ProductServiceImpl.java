package lk.abc.spring.service.impl;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.ProductDTO;
import lk.abc.spring.entity.Admin;
import lk.abc.spring.entity.Product;
import lk.abc.spring.exception.ValidateException;
import lk.abc.spring.repo.AdminRepo;
import lk.abc.spring.repo.ProductRepo;
import lk.abc.spring.service.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/24/21
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public void addProduct(ProductDTO dto) {
        if (productRepo.existsById(dto.getId())){
            throw new ValidateException("Product Already Exist");
        }
        productRepo.save(mapper.map(dto, Product.class));
    }


    @Override
    public void updateProduct(ProductDTO dto) {
        if(productRepo.existsById(dto.getId())){
            productRepo.save(mapper.map(dto,Product.class));
        }
    }

    @Override
    public void deleteProduct(String id) {
        if (!productRepo.existsById(id)) {
            throw new ValidateException("No Product to Delete..!!");
        }
        productRepo.deleteById(id);
    }

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        List<Product> all = productRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<ProductDTO>>(){}.getType());
    }

}
