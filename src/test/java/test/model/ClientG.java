package test.model;

import java.util.UUID;
import javax.annotation.Generated;
import ru.belov.trial.infrastructure.LocalizedString;

public class ClientG {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5478203+03:00", comments="Source field: client.uuid")
    private UUID uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.active")
    private Boolean active;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.name")
    private LocalizedString name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.city_code")
    private String cityCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.client_type_code")
    private String clientTypeCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.phone_number")
    private String phoneNumber;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.uuid")
    public UUID getUuid() {
        return uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.uuid")
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.active")
    public Boolean getActive() {
        return active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.active")
    public void setActive(Boolean active) {
        this.active = active;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.name")
    public LocalizedString getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.name")
    public void setName(LocalizedString name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.city_code")
    public String getCityCode() {
        return cityCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.city_code")
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.client_type_code")
    public String getClientTypeCode() {
        return clientTypeCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.client_type_code")
    public void setClientTypeCode(String clientTypeCode) {
        this.clientTypeCode = clientTypeCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.phone_number")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5634373+03:00", comments="Source field: client.phone_number")
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}