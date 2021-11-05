package lk.abc.spring.service;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;

import java.util.ArrayList;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */
public interface AdminService {
    void addAdmin(AdminDTO adminDTO);
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    ArrayList<AdminDTO> getAllAdmins();
    AdminDTO adminLogin(LoginRequestDTO loginRequestDTO);
}
