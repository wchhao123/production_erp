package com.team.service;

import com.team.bean.SysUser;
import com.team.bean.SysUserExample;
import com.team.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public int sysUserLogin(String name, String pwd) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(name);
        List<SysUser> sysUsers = userMapper.selectByExample(example);
        if (sysUsers == null || sysUsers.size() == 0)
            return -2;

        example = new SysUserExample();
        example.createCriteria().andUsernameEqualTo(name).andPasswordEqualTo(pwd);
        sysUsers = userMapper.selectByExample(example);

        if (sysUsers == null || sysUsers.size() == 0)
            return -1;

        return Integer.parseInt(sysUsers.get(0).getLocked());

    }
}
