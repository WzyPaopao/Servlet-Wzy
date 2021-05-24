package com.wzy.wzy_shop.service;

import com.wzy.wzy_shop.entity.Vip;

public interface VipService {
    int register(Vip vip);

    boolean checkUserIsExist(String username);

    boolean login(Vip vip);

    Vip getVipProfile(String username);
}
