package com.wzy.wzy_shop.service.impl;

import com.wzy.wzy_shop.dao.VipDao;
import com.wzy.wzy_shop.dao.impl.VipDaoImpl;
import com.wzy.wzy_shop.entity.Vip;
import com.wzy.wzy_shop.service.VipService;
import com.wzy.wzy_shop.util.CodecUtil;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.List;

public class VipServiceImpl implements VipService {
    private VipDao vipDao = new VipDaoImpl();

    @Override
    public int register(Vip vip) {
        String salt = CodecUtil.getSalt();
        String password = vip.getPassword();
        password = DigestUtils.md5Hex(salt + password);
        vip.setPassword(password);
        vip.setSalt(salt);

        return vipDao.save(vip);
    }

    @Override
    public boolean checkUserIsExist(String username) {
        List<Vip> vips = vipDao.findUserByUsername(username);
        return vips.size() > 0;
    }

    @Override
    public boolean login(Vip vip) {
        // 根据用户名查找用户
        List<Vip> vips = vipDao.findUserByUsername(vip.getUsername());
        if (vips.size() == 0) {
            return false;
        }

        // 对比密码
        Vip vip1 = vips.get(0);
        String salt = vip1.getSalt();
        if (DigestUtils.md5Hex(salt + vip.getPassword()).equals(vip1.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Vip getVipProfile(String username) {
        List<Vip> vips = vipDao.findUserByUsername(username);
        return vips.size() == 0 ? null : vips.get(0);
    }
}
