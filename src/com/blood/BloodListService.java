package com.blood;

import java.util.List;

/**
 * BloodListService
 * 服务层
 * @author 
 *
 */
public class BloodListService {
 
    BloodListDao cDao = new BloodListDao();
     
    /**
     * 添加
     * @param bloodlist
     * @return
     */
    public boolean add(BloodList bloodlist) {
        boolean f = false;
        if(!cDao.name(bloodlist.getName())) {
            cDao.add(bloodlist);
            f = true;
        }
        return f;
    }
     
    /**
     * 删除
     */
    public void del(int id) {
        cDao.delete(id);
    }
     
    /**
     * 修改
     * @return
     */
    public void update(BloodList bloodlist) {
        cDao.update(bloodlist);
    }
     
    /**
     * 通过ID得到一个BloodList
     * @return
     */
    public BloodList getBloodListById(int id) {
        return cDao.getBloodListById(id);
    }
 
    /**
     * 通过Name得到一个BloodList
     * @return
     */
    public BloodList getBloodListByName(String name) {
        return cDao.getBloodListByName(name);
    }
     
     
    /**
     * 全部数据
     * @return
     */
    public List<BloodList> list() {
        return cDao.list();
    }
}