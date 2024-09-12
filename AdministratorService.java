package cn.edu.dlu.secondclass.Service;

import cn.edu.dlu.secondclass.Dao.AdministratorMapper;
import cn.edu.dlu.secondclass.entity.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorMapper administratorMapper;

    public boolean register(Administrator admin) {
        return administratorMapper.register(admin) > 0;
    }

    public Administrator login(String username, String password) {
        return administratorMapper.login(username, password);
    }
}
