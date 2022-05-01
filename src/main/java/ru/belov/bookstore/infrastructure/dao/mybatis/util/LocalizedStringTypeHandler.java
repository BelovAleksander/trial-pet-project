package ru.belov.bookstore.infrastructure.dao.mybatis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import ru.belov.bookstore.infrastructure.util.JsonUtil;
import ru.belov.bookstore.domain.entity.LocalizedString;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Класс предназначен для преобразования {@link LocalizedString} в json и обратно в момент сохранения в БД
 */
public class LocalizedStringTypeHandler extends BaseTypeHandler<LocalizedString> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalizedString parameter, JdbcType jdbcType)
            throws SQLException {
        try {
            ps.setString(i, JsonUtil.toJSON(parameter));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public LocalizedString getNullableResult(ResultSet rs, String columnName) throws SQLException {
        try {
            return JsonUtil.fromJSON(rs.getString(columnName), LocalizedString.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LocalizedString getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        try {
            return JsonUtil.fromJSON(rs.getString(columnIndex), LocalizedString.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public LocalizedString getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        try {
            return JsonUtil.fromJSON(cs.getString(columnIndex), LocalizedString.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}