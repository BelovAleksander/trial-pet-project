package ru.belov.trial.dao.configuration;

import io.zonky.test.db.postgres.embedded.DatabasePreparer;
import org.flywaydb.core.Flyway;

import javax.sql.DataSource;
import java.sql.SQLException;

public class CustomFlywayPreparer implements DatabasePreparer {
    private final Flyway flyway;

    public CustomFlywayPreparer() {
        this.flyway = new Flyway();
        this.flyway.setBaselineOnMigrate(true);
        this.flyway.setLocations("classpath:/migrations");
    }

    @Override
    public void prepare(DataSource ds) {
        this.flyway.setDataSource(ds);
        this.flyway.migrate();
    }
}
