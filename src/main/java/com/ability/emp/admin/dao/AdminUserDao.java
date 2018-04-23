package com.ability.emp.admin.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ability.emp.admin.entity.AdminUserEntity;
import com.ability.emp.base.BaseDao;

@Mapper
public interface AdminUserDao<T> extends BaseDao<T>{
    List<AdminUserEntity> userSearch(AdminUserEntity adminUserEntit);
    Integer countLine(AdminUserEntity adminUserEntit);
}