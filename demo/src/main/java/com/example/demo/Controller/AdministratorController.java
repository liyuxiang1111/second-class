package com.example.demo.Controller;
import com.example.demo.model.Administrator;
import com.example.demo.Service.AdministratorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("/admin")
@CrossOrigin // 允许跨域
public class AdministratorController {
    private static final Logger logger = LoggerFactory.getLogger(AdministratorController.class);

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody Administrator admin) {
        try {
            logger.info("Received Admin: " + admin);
            boolean success = administratorService.register(admin);
            if (success) {
                logger.info("Registration successful for Admin: " + admin);
                return new ResponseEntity<>(true, HttpStatus.OK);
            } else {
                logger.error("Registration failed for Admin: " + admin);
                return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e) {
            logger.error("Error during registration: ", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<Administrator> login(@RequestParam String username, @RequestParam String password,
                                               @RequestParam String captcha,
                                               HttpServletRequest request) {
        String sessionCaptcha = (String) request.getSession().getAttribute("captcha");
        if (sessionCaptcha == null || !sessionCaptcha.equals(captcha)) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);  // 验证码错误
        }
        Administrator admin = administratorService.login(username, password);
        if (admin != null) {
            logger.info("Successful find for Admin: " + admin);
            return ResponseEntity.ok(admin);
        } else {
            logger.info("Bad find for Admin: " + admin);
            return ResponseEntity.badRequest().build();
        }
    }
}
