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
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getuserType() {
        return this.userType;
    }

    public void setuserType(Long userType) {
        this.userType = userType;
    }
    public String getuserNo() {
        return this.userNo;
    }

    public void setuserNo(String userNo) {
        this.userNo = userNo;
    }
    public String getuserName() {
        return this.userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }
    public String getemail() {
        return this.email;
    }

    public void setemail(String email) {
        this.email = email;
    }
    public String getmobile() {
        return this.mobile;
    }

    public void setmobile(String mobile) {
        this.mobile = mobile;
    }
    public String getinvite() {
        return this.invite;
    }

    public void setinvite(String invite) {
        this.invite = invite;
    }
    public String getphoto() {
        return this.photo;
    }

    public void setphoto(String photo) {
        this.photo = photo;
    }
    public Long getfinger() {
        return this.finger;
    }

    public void setfinger(Long finger) {
        this.finger = finger;
    }
    public Long getintegral() {
        return this.integral;
    }

    public void setintegral(Long integral) {
        this.integral = integral;
    }
    public String getintegralPassword() {
        return this.integralPassword;
    }

    public void setintegralPassword(String integralPassword) {
        this.integralPassword = integralPassword;
    }
    public String getpasswd() {
        return this.passwd;
    }

    public void setpasswd(String passwd) {
        this.passwd = passwd;
    }

}