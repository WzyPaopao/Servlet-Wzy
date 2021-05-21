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
}
