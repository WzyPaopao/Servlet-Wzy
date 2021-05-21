package com.wzy.wzy_shop.dao;

import com.wzy.wzy_shop.entity.Vip;

import java.util.List;

public interface VipDao {
    int save(Vip vip);

    List<Vip> findUserByUsername(String username);
}
