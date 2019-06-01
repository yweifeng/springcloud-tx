package ywf.service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
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

    @Autowired
    private ClientBService clientBService;

    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    public String testTx(String name, String errorFlag) {

        // 本地插入数据库
        User u = new User();
        u.setName("serviceA:" +name);
        userMapper.save(u);

        // 使用feign调用
        String rpcRes = "";
        rpcRes = clientBService.save(name);

        // 设置出现异常
        if (StringUtils.isNotBlank(errorFlag)) {
            int i = 1/0;
        }
        return rpcRes + " > serviceA ok" ;
    }
}
