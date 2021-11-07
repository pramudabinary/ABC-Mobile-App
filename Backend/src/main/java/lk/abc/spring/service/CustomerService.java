package lk.abc.spring.service;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.CustomerDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;

import java.util.ArrayList;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */
public interface CustomerService {
    void addCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String id);
    ArrayList<CustomerDTO> getAllCustomers();
    CustomerDTO customerLogin(LoginRequestDTO loginRequestDTO);
}
