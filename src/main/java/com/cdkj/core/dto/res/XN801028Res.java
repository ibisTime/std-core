package com.cdkj.core.dto.res;

import com.cdkj.core.bo.base.Page;
import com.cdkj.core.domain.Comment;

public class XN801028Res {
    // 评论分页列表
    private Page<Comment> page;

    // 分数平均数
    private Double avgScore;

    public XN801028Res() {
    }

    public XN801028Res(Page<Comment> page, Double avgScore) {
        this.page = page;
        this.avgScore = avgScore;
    }

    public Page<Comment> getPage() {
        return page;
    }

    public void setPage(Page<Comment> page) {
        this.page = page;
    }

    public Double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(Double avgScore) {
        this.avgScore = avgScore;
    }
}
