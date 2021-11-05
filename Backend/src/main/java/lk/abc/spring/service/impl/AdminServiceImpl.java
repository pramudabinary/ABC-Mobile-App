package lk.abc.spring.service.impl;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import lk.abc.spring.entity.Admin;
import lk.abc.spring.exception.ApplicationException;
import lk.abc.spring.exception.ValidateException;
import lk.abc.spring.repo.AdminRepo;
import lk.abc.spring.service.AdminService;
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
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void addAdmin(AdminDTO dto) {
        if (adminRepo.existsById(dto.getId())){
            throw new ValidateException("Customer Already Exist");
        }
        adminRepo.save(mapper.map(dto,Admin.class));
    }

    @Override
    public void updateAdmin(AdminDTO dto) {
        if(adminRepo.existsById(dto.getId())){
            adminRepo.save(mapper.map(dto,Admin.class));
        }
    }

    @Override
    public void deleteAdmin(String id) {
        if (!adminRepo.existsById(id)) {
            throw new ValidateException("No Admin to Delete..!!");
        }
        adminRepo.deleteById(id);
    }

    @Override
    public ArrayList<AdminDTO> getAllAdmins() {
        List<Admin> all = adminRepo.findAll();
        return mapper.map(all,new TypeToken<ArrayList<AdminDTO>>(){}.getType());
    }

    @Override
    public AdminDTO adminLogin(LoginRequestDTO loginRequestDTO) {
        Optional<Admin> admin = adminRepo.findAdminByNameAndPassword(loginRequestDTO.getUsername(),
                loginRequestDTO.getPassword());
        if (admin.isPresent()){
            return mapper.map(admin.get(),AdminDTO.class);
        }

        throw new ApplicationException("401","Incorrect UserName or Password");

    }
}
