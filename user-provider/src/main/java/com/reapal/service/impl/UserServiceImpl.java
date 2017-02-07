package com.reapal.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.reapal.mapper.UserMapper;
import com.reapal.model.User;
import com.reapal.service.UserService;

/**
 * Created by jack-cooper on 2017/2/7.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
