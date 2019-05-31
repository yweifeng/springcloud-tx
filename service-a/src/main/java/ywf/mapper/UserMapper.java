package ywf.mapper;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import ywf.domain.User;

@Mapper
public interface UserMapper {

    @Insert("insert into t_user(name) values (#{name})")
    void save(User user);
}
