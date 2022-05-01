package test.mapper;

import java.sql.JDBCType;
import java.util.UUID;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;
import ru.belov.bookstore.domain.entity.LocalizedString;

public final class ClientGDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.295291+03:00", comments="Source Table: client")
    public static final ClientG clientG = new ClientG();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.297604+03:00", comments="Source field: client.uuid")
    public static final SqlColumn<UUID> uuid = clientG.uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.298285+03:00", comments="Source field: client.active")
    public static final SqlColumn<Boolean> active = clientG.active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.298373+03:00", comments="Source field: client.name")
    public static final SqlColumn<LocalizedString> name = clientG.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.298433+03:00", comments="Source field: client.city_code")
    public static final SqlColumn<String> cityCode = clientG.cityCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.298493+03:00", comments="Source field: client.client_type_code")
    public static final SqlColumn<String> clientTypeCode = clientG.clientTypeCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.298553+03:00", comments="Source field: client.phone_number")
    public static final SqlColumn<String> phoneNumber = clientG.phoneNumber;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-28T08:36:00.296577+03:00", comments="Source Table: client")
    public static final class ClientG extends SqlTable {
        public final SqlColumn<UUID> uuid = column("uuid", JDBCType.OTHER);

        public final SqlColumn<Boolean> active = column("active", JDBCType.BIT);

        public final SqlColumn<LocalizedString> name = column("name", JDBCType.OTHER);

        public final SqlColumn<String> cityCode = column("city_code", JDBCType.VARCHAR);

        public final SqlColumn<String> clientTypeCode = column("client_type_code", JDBCType.VARCHAR);

        public final SqlColumn<String> phoneNumber = column("phone_number", JDBCType.VARCHAR);

        public ClientG() {
            super("client");
        }
    }
}