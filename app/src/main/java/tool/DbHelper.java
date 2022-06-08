package tool;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pojo.Doctor;

public class DbHelper {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://8.130.17.147:3306/db_android?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASS = "123456";
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet res = null;

    private static DbHelper dbHelper = null;

    public static DbHelper getInstance() {
        if (dbHelper == null) {
            synchronized (DbHelper.class) {
                if (dbHelper == null) {
                    dbHelper = new DbHelper();
                }
                return dbHelper;
            }
        }
        return dbHelper;
    }

    private DbHelper() {
        super();
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
    }

    public <T> List<T> select(String table, Class<T> clazz, Map<String, String> condition) {
        String sql = "select * from " + table;
        if (condition != null) {
            StringBuilder sb = new StringBuilder(" where ");
            condition.forEach((key, value) -> {
                try {
                    sb.append(key).append("=");
                    if (clazz.getField(key).getType() == String.class) {
                        sb.append("'").append(value).append("'");
                    } else {
                        sb.append(value).append(" acd ");
                    }
                } catch (NoSuchFieldException e) {
                    throw new RuntimeException(e);
                }
            });
            sb.delete(sb.length() - 5, sb.length());
            sql = sb.insert(0, sql).toString();
        }
        try {
            statement = connection.prepareStatement(sql);
            res = statement.executeQuery();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        try {
            List<T> result = new ArrayList<>();
            while (res.next()) {
                Object [] values = new Object[fields.length];
                for (int i = 0; i < values.length; i++) {
                    fields[i].setAccessible(true);
                    values[i] = res.getObject(fields[i].getName());
                }
                Class<?>[] classes = new Class[fields.length];
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    classes[i] = fields[i].getType();
                }
                result.add(clazz.getConstructor(classes).newInstance(values));
            }
            this.close(statement, res);
            return result;
        } catch (SQLException | InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException throwable) {
            throwable.printStackTrace();
            return null;
        }
    }

    public boolean insert(String table, @NotNull Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Object[] values;
        StringBuilder sb = new StringBuilder();
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                if (fields[i].get(object) != null) {
                    sb.append(fields[i].getName()).append("=").append("?");
                    list.add(fields[i].get(object));
                    if (i != fields.length - 1) {
                        sb.append(",");
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        values = list.toArray();
        try {
            String sql = "insert into " + table + " set " + sb;
            statement = connection.prepareStatement(sql);
            for (int i = 0; i < values.length; i++) {
                statement.setObject(i + 1, values[i]);
            }
            return statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void close(PreparedStatement statement, ResultSet res) {
        try {
            res.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close() {
        try {
            if (res != null) {
                res.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Doctor> select(String table) {
        return new ArrayList<Doctor>(){{
            add(new Doctor(100001, "李华", "专家", "儿科"));
            add(new Doctor(100002, "张红", "医师", "肛肠科"));
            add(new Doctor(100003, "杨佳玮", "专家", "妇科"));
            add(new Doctor(100004, "王可服", "医师", "外科"));
        }};
    }

}
