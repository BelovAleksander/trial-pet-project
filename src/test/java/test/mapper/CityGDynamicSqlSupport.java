package test.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import ru.belov.trial.infrastructure.LocalizedString;

public final class CityGDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    public static final CityG cityG = new CityG();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.code")
    public static final SqlColumn<String> code = cityG.code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.name")
    public static final SqlColumn<LocalizedString> name = cityG.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source Table: city")
    public static final class CityG extends SqlTable {
        public final SqlColumn<String> code = column("code", JDBCType.VARCHAR);

        public final SqlColumn<LocalizedString> name = column("name", JDBCType.OTHER);

        public CityG() {
            super("city");
        }
    }
}