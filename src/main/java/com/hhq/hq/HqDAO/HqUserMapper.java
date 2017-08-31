package com.hhq.hq.HqDAO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HqUserMapper implements RowMapper<HqUser> {
    @Override
    public HqUser mapRow(ResultSet resultSet, int i) throws SQLException {

        HqUser user = new HqUser();
        user.setId(resultSet.getInt("userId"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}
