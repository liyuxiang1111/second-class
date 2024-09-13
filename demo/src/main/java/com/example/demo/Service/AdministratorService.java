package com.example.demo.Service;
import com.example.demo.model.Administrator;
import com.example.demo.Mapper.AdministratorMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AdministratorService {
    private static final Logger logger = LoggerFactory.getLogger(AdministratorService.class);
    @Autowired
    private AdministratorMapper administratorMapper;
    @Transactional
    public boolean register(Administrator admin) {
        int rowsAffected = administratorMapper.register(admin);
        logger.info("Rows affected by insert: " + rowsAffected);  // 打印影响的行数
        return rowsAffected > 0;
    }

    public Administrator login(String username, String password) {
        return administratorMapper.login(username, password);
    }
}
