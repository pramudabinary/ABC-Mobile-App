package lk.abc.spring.service.impl;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.CustomerDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import lk.abc.spring.entity.Admin;
import lk.abc.spring.entity.Customer;
import lk.abc.spring.exception.ApplicationException;
import lk.abc.spring.exception.ValidateException;
import lk.abc.spring.repo.AdminRepo;
import lk.abc.spring.repo.CustomerRepo;
import lk.abc.spring.service.AdminService;
import lk.abc.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addCustomer(CustomerDTO dto) {
        if (customerRepo.existsById(dto.getId())){
            throw new ValidateException("Customer Already Exist");
        }
        customerRepo.save(mapper.map(dto, Customer.class));
    }

    @Override
    public void updateCustomer(CustomerDTO dto) {
        if(customerRepo.existsById(dto.getId())){
            customerRepo.save(mapper.map(dto,Customer.class));
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No Admin to Delete..!!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> all = customerRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
    }

    @Override
    public CustomerDTO customerLogin(LoginRequestDTO loginRequestDTO) {
        Optional<Customer> customer = customerRepo.findCustomerByNameAndPassword(loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword());
        if (customer.isPresent()){
            return mapper.map(customer.get(),CustomerDTO.class);
        }

        throw new ApplicationException("401","Incorrect UserName or Password");

    }
}
