package test.model;

import javax.annotation.Generated;
import ru.belov.trial.infrastructure.LocalizedString;

public class CityG {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.code")
    private String code;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.name")
    private LocalizedString name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.code")
    public String getCode() {
        return code;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.code")
    public void setCode(String code) {
        this.code = code;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.name")
    public LocalizedString getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-10-24T19:48:16.5790662+03:00", comments="Source field: city.name")
    public void setName(LocalizedString name) {
        this.name = name;
    }
}