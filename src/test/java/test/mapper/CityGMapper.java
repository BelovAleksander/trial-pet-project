package test.mapper;

import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static test.mapper.CityGDynamicSqlSupport.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
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
import test.model.CityG;

@Mapper
public interface CityGMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    BasicColumn[] selectList = BasicColumn.columnList(code, name);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CityG> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CityG> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CityGResult")
    Optional<CityG> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CityGResult", value = {
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.OTHER)
    })
    List<CityG> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int deleteByPrimaryKey(String code_) {
        return delete(c -> 
            c.where(code, isEqualTo(code_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int insert(CityG record) {
        return MyBatis3Utils.insert(this::insert, record, cityG, c ->
            c.map(code).toProperty("code")
            .map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int insertMultiple(Collection<CityG> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, cityG, c ->
            c.map(code).toProperty("code")
            .map(name).toProperty("name")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int insertSelective(CityG record) {
        return MyBatis3Utils.insert(this::insert, record, cityG, c ->
            c.map(code).toPropertyWhenPresent("code", record::getCode)
            .map(name).toPropertyWhenPresent("name", record::getName)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default Optional<CityG> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default List<CityG> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default List<CityG> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default Optional<CityG> selectByPrimaryKey(String code_) {
        return selectOne(c ->
            c.where(code, isEqualTo(code_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, cityG, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    static UpdateDSL<UpdateModel> updateAllColumns(CityG record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalTo(record::getCode)
                .set(name).equalTo(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CityG record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(code).equalToWhenPresent(record::getCode)
                .set(name).equalToWhenPresent(record::getName);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int updateByPrimaryKey(CityG record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .where(code, isEqualTo(record::getCode))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5946884+03:00", comments="Source Table: city")
    default int updateByPrimaryKeySelective(CityG record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .where(code, isEqualTo(record::getCode))
        );
    }
}