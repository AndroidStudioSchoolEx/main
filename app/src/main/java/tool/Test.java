package tool;

import pojo.Doctor;

public class Test {

    public static void main(String[] args) {
        System.out.println(DbHelper.getInstance().select("doctor", Doctor.class, null));
        System.out.println(DbHelper.getInstance().insert("doctor", new Doctor()));
        DbHelper.getInstance().close();
    }

}
