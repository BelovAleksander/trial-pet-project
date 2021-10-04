package ru.belov.trial.dao.mybatis.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDate;
import java.util.Optional;

public class LocalDateTypeHandler implements TypeHandler<LocalDate> {

    @Override
    public void setParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType) throws SQLException {
        ps.setDate(i, Date.valueOf(parameter));
    }

    @Override
    public LocalDate getResult(ResultSet rs, String columnName) throws SQLException {
        return Optional.ofNullable(rs.getDate(columnName)).map(Date::toLocalDate).orElse(null);
    }

    @Override
    public LocalDate getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Optional.ofNullable(rs.getDate(columnIndex)).map(Date::toLocalDate).orElse(null);
    }

    @Override
    public LocalDate getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Optional.ofNullable(cs.getDate(columnIndex)).map(Date::toLocalDate).orElse(null);
    }
}
