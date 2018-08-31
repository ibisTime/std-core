package com.cdkj.core.dto.req;

/**
 * @author: xieyj 
 * @since: 2016年9月17日 下午4:09:23 
 * @history:
 */
public class XN660905Req extends APageReq {

    // 类型（第一层/第二层）
    private String type;

    // 父key
    private String parentKey;

    // key
    private String dkey;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getDkey() {
        return dkey;
    }

    public void setDkey(String dkey) {
        this.dkey = dkey;
    }
}
