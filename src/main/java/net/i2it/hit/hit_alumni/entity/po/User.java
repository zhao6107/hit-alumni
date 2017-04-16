package net.i2it.hit.hit_alumni.entity.po;

/**
 * Created by liuming on 2017/4/16.
 */
public class User {

    private String id;
    private String name;
    private boolean sex;
    private int age;

    public User() {
    }

    public User(String id, String name, boolean sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
