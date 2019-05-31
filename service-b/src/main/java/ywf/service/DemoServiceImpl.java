package ywf.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ywf.domain.User;
import ywf.mapper.UserMapper;

@Service
@Slf4j
public class DemoServiceImpl {

    @Autowired
    private UserMapper userMapper;

    @Transactional
    @LcnTransaction(propagation = DTXPropagation.SUPPORTS)
    public String save(String name) {

        // 本地插入数据库
        User u = new User();
        u.setName("serviceB:" + name);
        userMapper.save(u);
        return "serviceB ok" ;
    }
}
