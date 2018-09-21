package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class SysUser extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //用户类型
    private Long userType;
    //用户编码
    private String userNo;
    //用户名称
    private String userName;
    //邮箱
    private String email;
    //手机
    private String mobile;
    //邀请码
    private String invite;
    //头像url
    private String photo;
    //开启指纹密码
    private Long finger;
    //是否启用积分密码
    private Long integral;
    //积分密码
    private String integralPassword;
    //
    private String passwd;
///////////////////////////////////////////////////////////////
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserType() {
        return this.userType;
    }

    public void setUserType(Long userType) {
        this.userType = userType;
    }
    public String getUserNo() {
        return this.userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getInvite() {
        return this.invite;
    }

    public void setInvite(String invite) {
        this.invite = invite;
    }
    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Long getFinger() {
        return this.finger;
    }

    public void setFinger(Long finger) {
        this.finger = finger;
    }
    public Long getIntegral() {
        return this.integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }
    public String getIntegralPassword() {
        return this.integralPassword;
    }

    public void setIntegralPassword(String integralPassword) {
        this.integralPassword = integralPassword;
    }
    public String getPasswd() {
        return this.passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}