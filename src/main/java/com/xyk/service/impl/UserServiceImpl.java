package com.xyk.service.impl;

import com.xyk.dao.PageResDaoImpl;
import com.xyk.dao.UserDao;
import com.xyk.entity.PageRes;
import com.xyk.entity.User;
import com.xyk.service.UserService;
import com.xyk.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Autowired
    PageResDaoImpl pageResDao;
    @Override
    public User login(String username, String password) {
        //密码加密
        password = StringUtil.EncoderByMd5(password);
        User user = userDao.findUserByUsernameAndPwd(username, password);
        if(user == null){
            return null;
        }
        user.setPassword(null);
        List<PageRes> pageResList =pageResDao.findResByUserId();
        user.setResList(pageResList);
        return user;
    }
}
