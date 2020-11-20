package com.example.demo.AdminRepository;
import com.example.demo.pojo.Admin;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@RequestMapping(value="/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;
    @ApiOperation(value = "管理员登录",notes="传入账号密码，验证身份,验证成功则返回token")
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public JSONObject loginAdmin(@RequestParam(value = "admin_id") String adminId,
                                 @RequestParam(value = "admin_password") String adminPassword)  {

        Admin adminEntity= adminRepository.findByAdminId(adminId);
        JSONObject result=new JSONObject();

        if(!adminEntity.getAdminPassword().equals(adminPassword)){
            result.put("port","400");
            return result;
        }
        else{
            result.put("port","200");
            return result;
        }

    }
}
