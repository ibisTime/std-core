package com.cdkj.core.ao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.dto.req.XN003010Req;
import com.cdkj.core.dto.res.XN801028Res;

@Component
public interface ICommentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public List<String> comment(XN003010Req req);

    public void dropComment(String code);

    public void approveComment(String code, String result, String approver,
            String remark);

    public Paginable<Comment> queryOssCommentPage(int start, int limit,
            Comment condition);

    public XN801028Res queryFrontCommentPage(int start, int limit,
            Comment condition);

    public Comment getComment(String code);

    public Long totalComment(String entityCode, String companyCode,
            String systemCode);

    public String comment(String type, String orderCode, String entityCode,
            String entityName, String parentCode, String content,
            String commenter, String commenterName, String companyCode,
            String systemCode);

    public Comment getCommentByOrderCode(String orderCode, String companyCode,
            String systemCode);

    public Paginable<Comment> queryBizCommentPage(int start, int limit,
            Comment condition);

}
