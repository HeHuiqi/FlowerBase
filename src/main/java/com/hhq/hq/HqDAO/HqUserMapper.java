package com.hhq.hq.HqDAO;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HqUserMapper implements RowMapper<HqUser> {
    @Override
    public HqUser mapRow(ResultSet resultSet, int i) throws SQLException {

        HqUser user = new HqUser();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setSex(resultSet.getString("sex"));
        return user;
    }
}
