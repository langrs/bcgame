package com.wm.bcgame.model;
import com.wm.bcgame.base.AbstractModel;


/**
* 描述：
* @author lzm
* @date 2018/09/07
*/
public class UserFavorite extends AbstractModel {

    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private Long userId;
    //收藏类型
    private Long favoriteType;
    //类型ID
    private Long favoriteId;
///////////////////////////////////////////////////////////////
    public Long getid() {
        return this.id;
    }

    public void setid(Long id) {
        this.id = id;
    }
    public Long getuserId() {
        return this.userId;
    }

    public void setuserId(Long userId) {
        this.userId = userId;
    }
    public Long getfavoriteType() {
        return this.favoriteType;
    }

    public void setfavoriteType(Long favoriteType) {
        this.favoriteType = favoriteType;
    }
    public Long getfavoriteId() {
        return this.favoriteId;
    }

    public void setfavoriteId(Long favoriteId) {
        this.favoriteId = favoriteId;
    }

}