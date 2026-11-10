package cn.freepointer.entity;

/**
 * 用户实体类，对应数据库user表
 */
public class User {
    private Integer id;
    private String username;
    private String password;
    private Integer role;

    // 无参构造（JavaBean必须）
    public User() {}

    // 带参构造，方便创建对象
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getter和setter
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Integer getRole() { return role; }
    public void setRole(Integer role) { this.role = role; }
}
