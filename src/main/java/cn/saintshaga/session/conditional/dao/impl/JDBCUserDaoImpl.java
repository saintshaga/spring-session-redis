package cn.saintshaga.session.conditional.dao.impl;

import cn.saintshaga.session.conditional.dao.UserDao;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by huang on 18-9-20.
 */
public class JDBCUserDaoImpl implements UserDao {
    @Override
    public List<String> getAllUserIds() {
        return Lists.newArrayList("jdbc1", "jdbc2");
    }
}
