package com.aaron.user.model;

/**
 * .
 * Creator:aaron_yong
 * Date:2017/1/17
 * Time:20:15
 */
public class UserVO {
    /** 用户id号*/
    private String id;
    /** 用户昵称*/
    private String userName;
    /** 用户登录账号*/
    private String loginName;
    /** 用户登录密码*/
    private String password;
    /** QQ登录名*/
    private String qqName;
    /** 微信登录名*/
    private String wxName;
    /** 性别*/
    private int sex;

    /**用户男性用0代替*/
    public static int SEX_MAN=1;
    /**用户女性用1代替*/
    public static int SEX_WOMAN=0;

    private  UserVO(){}

    public static  UserVO getInstance(){
        return new UserVO();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getQqName() {
        return qqName;
    }

    public void setQqName(String qqName) {
        this.qqName = qqName;
    }

    public String getWxName() {
        return wxName;
    }

    public void setWxName(String wxName) {
        this.wxName = wxName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    /**  判断是否为女性*/
    public boolean isMan(){
        if(SEX_MAN==sex){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", qqName='" + qqName + '\'' +
                ", wxName='" + wxName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
