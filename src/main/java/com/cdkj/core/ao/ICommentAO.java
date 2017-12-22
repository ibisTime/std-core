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

    public void comment(String entityCode, String type, String userId,
            String content, String parentCode, String companyCode,
            String systemCode);

    public void dropComment(String code);

    public void approveComment(String code, String result, String approver,
            String remark);

    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition);

    public XN801028Res queryFrontScoreCommentPage(int start, int limit,
            Comment condition);

    public Paginable<Comment> queryFrontCommentPage(int start, int limit,
            Comment condition);

    public Paginable<Comment> queryFrontOneCommentPage(int start, int limit,
            Comment condition);

    public Comment getComment(String code);

}
