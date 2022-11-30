package com.xiaoxianchen.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiaoxianchen.common.result.ResResponse;
import com.xiaoxianchen.common.result.Result;
import com.xiaoxianchen.entity.User;
import com.xiaoxianchen.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author hp
 * @version 1.0
 * @description: TODO
 * @date 2022/11/25 21:35
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserMapper userMapper;

    /**
     * 增加用户
     * @param user
     * @return
     */
    @PostMapping
    public Result<?> save(@RequestBody User user){
        userMapper.insert(user);
        return ResResponse.makeOKRsp();
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @PutMapping
    public Result<?> update(@RequestBody User user){
        userMapper.updateById(user);
        return ResResponse.makeOKRsp();
    }
    /**
     *
     */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Long id){
        userMapper.deleteById(id);
        return ResResponse.makeOKRsp();
    }
    /**
     * 根据昵称模糊查询
     * @param pageNum 当前页码
     * @param pageSize 当前页数
     * @param search 模糊查询昵称
     * @return
     */
    @GetMapping()
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> queryWrapper = Wrappers.lambdaQuery();
        if(StrUtil.isNotBlank(search)){
            queryWrapper.like(User::getNickName,search);
        }
        IPage<User> userInfo = userMapper.selectPage(new Page<>(pageNum, pageSize), queryWrapper);
       // System.out.println(userInfo.getRecords());
        return ResResponse.makeOKRsp(userInfo);
    }
    //secend commit
    //hot-fix commit1
    //master commit
}





























