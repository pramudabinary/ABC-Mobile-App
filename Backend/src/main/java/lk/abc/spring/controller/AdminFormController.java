package lk.abc.spring.controller;

import lk.abc.spring.dto.AdminDTO;
import lk.abc.spring.dto.json.request.LoginRequestDTO;
import lk.abc.spring.exception.NotFoundException;
import lk.abc.spring.service.AdminService;
import lk.abc.spring.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author Pramuda Liyanage <pramudatharika@gmail.com>
 * @since 10/20/21
 */

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminFormController {

    @Autowired
    private AdminService adminService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/0auth/token" )
    public ResponseEntity<StandardResponse> findAdminByNameAndPassword(@RequestBody LoginRequestDTO loginRequestDTO) {
        AdminDTO adminDTO = adminService.adminLogin(loginRequestDTO);

        return new ResponseEntity<>(new StandardResponse("200", "Login Success", adminDTO),
                HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/crud/add" )
    public ResponseEntity<StandardResponse> saveAdmin(@RequestBody AdminDTO dto ){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("No ID Provided!!");
        }
        adminService.addAdmin(dto);
        return new ResponseEntity<>(new StandardResponse("201",
                "Admin Created",dto),HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE,
            path ="/crud/update" )
    public ResponseEntity<StandardResponse> updateAdmin(@RequestBody AdminDTO dto ){
        if (dto.getId().trim().length() <= 0) {
            throw new NotFoundException("No ID Provided!!");
        }
        adminService.updateAdmin(dto);
        return new ResponseEntity<>(new StandardResponse("200","Admin Updated",dto),HttpStatus.ACCEPTED);
    }

    @DeleteMapping(params ={"id"},produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<StandardResponse> deleteAdmin(@RequestParam String id ){
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(new StandardResponse("200","Product Deleted!!",null),HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,path = "/crud/all")
    public ResponseEntity<StandardResponse> getAllAdmins(){
        ArrayList<AdminDTO> allAdmins = adminService.getAllAdmins();
        return new ResponseEntity<>(new StandardResponse("200","Done",allAdmins),HttpStatus.OK);
    }
}
