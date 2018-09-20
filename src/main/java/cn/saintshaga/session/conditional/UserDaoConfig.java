package cn.saintshaga.session.conditional;

import cn.saintshaga.session.conditional.dao.UserDao;
import cn.saintshaga.session.conditional.dao.impl.CassnadraUserDaoImpl;
import cn.saintshaga.session.conditional.dao.impl.JDBCUserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by huang on 18-9-20.
 */
@Configuration
public class UserDaoConfig {

    @Bean
    @DatabaseType("cassandra")
    UserDao cassandraUserDao() {
        return new CassnadraUserDaoImpl();
    }

    @Bean
    @DatabaseType("jdbc")
    UserDao jdbcUserDao() {
        return new JDBCUserDaoImpl();
    }
}
