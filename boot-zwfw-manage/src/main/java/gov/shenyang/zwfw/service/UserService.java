package gov.shenyang.zwfw.service;

import gov.shenyang.zwfw.dto.PaginationDTO;
import gov.shenyang.zwfw.mapper.UserMapper;
import gov.shenyang.zwfw.model.User;
import gov.shenyang.zwfw.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:LoginService
 * Package:gov.shengyang.zwfw.service
 * Description:
 *
 * @Date:2020/2/28 下午 10:09
 * @Author:gaochenyu2020@163.com
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andLoginNameEqualTo(user.getLoginName());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0){
            // 添加用户数据
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            // 更新用户数据
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAddress(user.getAddress());
            updateUser.setUserTel(user.getUserTel());
            updateUser.setUserEmail(user.getUserEmail());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria()
                    .andUserIdEqualTo(dbUser.getUserId());
            userMapper.updateByExampleSelective(updateUser,example);
        }
    }

    public User findUserByLoginName(String loginName){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andLoginNameEqualTo(loginName);
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() < 1){
            return null;
        }
        return users.get(0);
    }

    public PaginationDTO list() {
        PaginationDTO<User> paginationDTO = new PaginationDTO<>();
        UserExample userExample = new UserExample();
        userExample.createCriteria();
        userExample.setOrderByClause("gmt_create");
        List<User> users = userMapper.selectByExample(userExample);
        paginationDTO.setCount(users.size());
        paginationDTO.setData(users);
        return paginationDTO;
    }

    public boolean delete(Long userId) {
        int res = userMapper.deleteByPrimaryKey(userId);
        if (res > 0){
            return true;
        }
        return false;
    }
}
