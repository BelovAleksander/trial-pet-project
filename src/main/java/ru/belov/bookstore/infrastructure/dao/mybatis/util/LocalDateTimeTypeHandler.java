package ru.belov.bookstore.infrastructure.dao.mybatis.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class LocalDateTimeTypeHandler implements TypeHandler<LocalDateTime> {

    @Override
    public void setParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setTimestamp(i, (parameter != null ? Timestamp.valueOf(parameter) : null));
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, String columnName) throws SQLException {
        return Optional.ofNullable(rs.getTimestamp(columnName)).map(Timestamp::toLocalDateTime).orElse(null);
    }

    @Override
    public LocalDateTime getResult(ResultSet rs, int columnIndex) throws SQLException {
        return Optional.ofNullable(rs.getTimestamp(columnIndex)).map(Timestamp::toLocalDateTime).orElse(null);
    }

    @Override
    public LocalDateTime getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return Optional.ofNullable(cs.getTimestamp(columnIndex)).map(Timestamp::toLocalDateTime).orElse(null);
    }
}
