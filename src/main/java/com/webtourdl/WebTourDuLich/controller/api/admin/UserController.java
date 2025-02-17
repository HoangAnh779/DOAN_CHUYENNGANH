package com.webtourdl.WebTourDuLich.controller.api.admin;

import com.webtourdl.WebTourDuLich.dto.ResponseDTO;
import com.webtourdl.WebTourDuLich.dto.UpdateUserDTO;
import com.webtourdl.WebTourDuLich.dto.UserDTO;
import com.webtourdl.WebTourDuLich.entity.User;
import com.webtourdl.WebTourDuLich.service.UserService;
import com.webtourdl.WebTourDuLich.utilities.ConvertUserToDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseDTO getAllUser(
            @RequestParam(value = "sdt",required = false) String sdt,
            @RequestParam(value = "email",required = false) String email,
            @RequestParam(value = "ho_ten",required = false) String ho_ten,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
            @RequestParam("pageIndex") Integer pageIndex
            ) {
        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        Page<UserDTO> page = this.userService.findAllUser(sdt,email,ho_ten, PageRequest.of(pageIndex,pageSize));

        return new ResponseDTO("Thành công",page.getContent());
    }

    @GetMapping("/{id}")
    public ResponseDTO getOneUser(@PathVariable("id") Long id) {

        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        if(this.userService.findUserById(id)!=null) {
            return new ResponseDTO("Thành công", ConvertUserToDto.convertUsertoDto(this.userService.findUserById(id)));
        }
        return new ResponseDTO("Thất bại",null);
    }

    @PutMapping("/update/{id}")
    public ResponseDTO updateUser(@PathVariable("id") Long id, @RequestBody UpdateUserDTO updateUserDTO) {

        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        User user = this.userService.findUserById(id);

        if(user!=null) {
            if(this.userService.updateUserByAdmin(updateUserDTO,id)) {
                return new ResponseDTO("Cập nhật thành công",this.userService.findUserById(id));
            }
        }
        return new ResponseDTO("Cập nhật thất bại",null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable("id") Long id){


        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        User user = this.userService.findUserById(id);
        if(user!=null) {

            if(this.userService.deleteUserById(id)) {
                return new ResponseDTO("Xóa thành công",null);
            }
        }

        return new ResponseDTO("Không thể xóa người dùng này",null);
    }

    @PutMapping("/update/resetPass/{id}")
    public ResponseDTO resetPass(@PathVariable("id") Long id) {

        if(!this.userService.checkAdminLogin()) {
            return new ResponseDTO("Không có quyền truy cập",null);
        }

        if(this.userService.resetPass(id)) {
            return new ResponseDTO("Khôi phục mật khẩu mặc định thành công",null);
        }
        return new ResponseDTO("Khôi phục mật khẩu mặc định thất bại",null);

    }

    @GetMapping("/user-count")
    public ResponseDTO getUserCount() {
        long userCount = userService.countUsers();
        Map<String, Long> response = new HashMap<>();
        response.put("count", userCount);
        return new ResponseDTO("Thành công", response);
    }
}
