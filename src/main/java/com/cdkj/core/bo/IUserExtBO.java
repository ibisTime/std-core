package com.cdkj.core.bo;

import com.cdkj.core.bo.base.IPaginableBO;
import com.cdkj.core.domain.UserExt;

public interface IUserExtBO extends IPaginableBO<UserExt> {

    public void refreshUserPhoto(String userId, String photo);

    public void refreshUserExt(String userId, String photo, String gender,
            String birthday, String email, String introduce);

    public void refreshNickname(String userId, String nickname);

    public void refreshLoginName(String userId, String loginName);
}
