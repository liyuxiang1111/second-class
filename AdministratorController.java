package cn.edu.dlu.secondclass.Controller;

import cn.edu.dlu.secondclass.Service.AdministratorService;
import cn.edu.dlu.secondclass.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody Administrator admin) {
        boolean success = administratorService.register(admin);
        if (success) {
            return ResponseEntity.ok(true);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Administrator> login(@RequestParam String username, @RequestParam String password) {
        Administrator admin = administratorService.login(username, password);
        if (admin != null) {
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}