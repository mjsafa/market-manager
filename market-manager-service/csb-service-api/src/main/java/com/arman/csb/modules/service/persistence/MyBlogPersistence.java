package com.arman.csb.modules.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;
import com.liferay.portlet.blogs.model.BlogsEntry;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 9/7/14
 * Time: 3:55 PM
 */
public interface MyBlogPersistence extends BasePersistence<BlogsEntry>{

    public List<BlogsEntry> findGroupEntries(long groupId, int status, int start, int end, String tags, String categories);
}
