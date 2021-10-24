package test.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static test.mapper.ClientGDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import test.model.ClientG;

@Mapper
public interface ClientGMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    BasicColumn[] selectList = BasicColumn.columnList(uuid, active, name, cityCode, clientTypeCode, phoneNumber);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ClientG> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ClientG> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ClientGResult")
    Optional<ClientG> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ClientGResult", value = {
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.OTHER, id=true),
        @Result(column="active", property="active", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.OTHER),
        @Result(column="city_code", property="cityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="client_type_code", property="clientTypeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_number", property="phoneNumber", jdbcType=JdbcType.VARCHAR)
    })
    List<ClientG> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source Table: client")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int deleteByPrimaryKey(UUID uuid_) {
        return delete(c -> 
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int insert(ClientG record) {
        return MyBatis3Utils.insert(this::insert, record, clientG, c ->
            c.map(uuid).toProperty("uuid")
            .map(active).toProperty("active")
            .map(name).toProperty("name")
            .map(cityCode).toProperty("cityCode")
            .map(clientTypeCode).toProperty("clientTypeCode")
            .map(phoneNumber).toProperty("phoneNumber")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int insertMultiple(Collection<ClientG> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, clientG, c ->
            c.map(uuid).toProperty("uuid")
            .map(active).toProperty("active")
            .map(name).toProperty("name")
            .map(cityCode).toProperty("cityCode")
            .map(clientTypeCode).toProperty("clientTypeCode")
            .map(phoneNumber).toProperty("phoneNumber")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int insertSelective(ClientG record) {
        return MyBatis3Utils.insert(this::insert, record, clientG, c ->
            c.map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(active).toPropertyWhenPresent("active", record::getActive)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(cityCode).toPropertyWhenPresent("cityCode", record::getCityCode)
            .map(clientTypeCode).toPropertyWhenPresent("clientTypeCode", record::getClientTypeCode)
            .map(phoneNumber).toPropertyWhenPresent("phoneNumber", record::getPhoneNumber)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default Optional<ClientG> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default List<ClientG> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default List<ClientG> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default Optional<ClientG> selectByPrimaryKey(UUID uuid_) {
        return selectOne(c ->
            c.where(uuid, isEqualTo(uuid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, clientG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    static UpdateDSL<UpdateModel> updateAllColumns(ClientG record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalTo(record::getUuid)
                .set(active).equalTo(record::getActive)
                .set(name).equalTo(record::getName)
                .set(cityCode).equalTo(record::getCityCode)
                .set(clientTypeCode).equalTo(record::getClientTypeCode)
                .set(phoneNumber).equalTo(record::getPhoneNumber);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ClientG record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(uuid).equalToWhenPresent(record::getUuid)
                .set(active).equalToWhenPresent(record::getActive)
                .set(name).equalToWhenPresent(record::getName)
                .set(cityCode).equalToWhenPresent(record::getCityCode)
                .set(clientTypeCode).equalToWhenPresent(record::getClientTypeCode)
                .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int updateByPrimaryKey(ClientG record) {
        return update(c ->
            c.set(active).equalTo(record::getActive)
            .set(name).equalTo(record::getName)
            .set(cityCode).equalTo(record::getCityCode)
            .set(clientTypeCode).equalTo(record::getClientTypeCode)
            .set(phoneNumber).equalTo(record::getPhoneNumber)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: client")
    default int updateByPrimaryKeySelective(ClientG record) {
        return update(c ->
            c.set(active).equalToWhenPresent(record::getActive)
            .set(name).equalToWhenPresent(record::getName)
            .set(cityCode).equalToWhenPresent(record::getCityCode)
            .set(clientTypeCode).equalToWhenPresent(record::getClientTypeCode)
            .set(phoneNumber).equalToWhenPresent(record::getPhoneNumber)
            .where(uuid, isEqualTo(record::getUuid))
        );
    }
}