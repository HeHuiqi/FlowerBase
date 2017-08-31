package com.hhq.hq.HqDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

public class HqUserDAOImp implements HqUserDAO {

    @Autowired
    private  DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Autowired 用户属性后可以不用写setter方法

//    @Autowired
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    @Autowired
//    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    @Override
    public HqUser getUser(Integer id) {

        String sql = "select * from user where userId = ?";
        HqUserMapper mapper = new HqUserMapper();

        try {
            HqUser user = jdbcTemplate.queryForObject(sql,new Object[]{id},mapper);
            return user;
        }catch (Exception e){

            return null;
        }
    }
}
