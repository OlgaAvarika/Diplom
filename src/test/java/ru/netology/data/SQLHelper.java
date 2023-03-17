package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import ru.netology.databaseentities.CreditEntity;
import ru.netology.databaseentities.PaymentEntity;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private static String url = System.getProperty("db.url");
    private static Connection connection;

    @SneakyThrows
    public static Connection getConnect() {
        try {
            connection = DriverManager.getConnection(url, "app", "pass");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
    @SneakyThrows
    public static String getApprovedStatusWhenPayment() {
        var statusSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'APPROVED'";
        try (Connection connection = getConnect()) {
            var result = runner.query(connection, statusSQL, new BeanHandler<>(PaymentEntity.class));
            return result.getStatus();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    @SneakyThrows
    public static String getDeclinedStatusWhenPayment() {
        var statusSQL = "SELECT * FROM payment_entity JOIN order_entity ON transaction_id = payment_id where status = 'DECLINED'";
        try (Connection connection = getConnect()) {
            var result = runner.query(connection, statusSQL, new BeanHandler<>(PaymentEntity.class));
            return result.getStatus();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    @SneakyThrows
    public static String getApprovedStatusWhenCredit() {
        var statusSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = payment_id where status = 'APPROVED'";
        try (Connection connection = getConnect()) {
            var result = runner.query(connection, statusSQL, new BeanHandler<>(CreditEntity.class));
            return result.getStatus();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    @SneakyThrows
    public static String getDeclinedStatusWhenCredit() {
        var statusSQL = "SELECT * FROM credit_request_entity JOIN order_entity ON bank_id = payment_id where status = 'DECLINED'";
        try (Connection connection = getConnect()) {
            var result = runner.query(connection, statusSQL, new BeanHandler<>(CreditEntity.class));
            return result.getStatus();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
    @SneakyThrows
    public static void cleanDatabase() {
        var connection = getConnect();
        runner.execute(connection, "DELETE FROM order_entity");
        runner.execute(connection, "DELETE FROM payment_entity");
        runner.execute(connection, "DELETE FROM credit_request_entity");
    }
}
