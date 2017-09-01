package com.cdkj.core.ao;

import org.springframework.stereotype.Component;

import com.cdkj.core.bo.base.Paginable;
import com.cdkj.core.domain.Comment;
import com.cdkj.core.dto.req.XN801020Req;

@Component
public interface ICommentAO {
    static final String DEFAULT_ORDER_COLUMN = "code";

    public String comment(XN801020Req req);

    public void dropComment(String code);

    public void approveComment(String code, String result, String approver,
            String remark);

    public Paginable<Comment> queryCommentPage(int start, int limit,
            Comment condition);

    public Comment getComment(String code);

}
