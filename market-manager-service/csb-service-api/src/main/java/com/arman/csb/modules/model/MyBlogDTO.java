package com.arman.csb.modules.model;

import com.liferay.portlet.blogs.model.BlogsEntry;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 9/18/14
 * Time: 9:30 AM
 */
public class MyBlogDTO implements Serializable {
    BlogsEntry entry;
    int commentCount;

    public BlogsEntry getEntry() {
        return entry;
    }

    public void setEntry(BlogsEntry entry) {
        this.entry = entry;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }
}
