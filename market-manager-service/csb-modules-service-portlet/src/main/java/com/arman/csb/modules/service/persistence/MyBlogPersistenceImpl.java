package com.arman.csb.modules.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 9/7/14
 * Time: 3:44 PM
 */
public class MyBlogPersistenceImpl extends BasePersistenceImpl<BlogsEntry> implements MyBlogPersistence {

    public List<BlogsEntry> findGroupEntries(long groupId, int status, int start, int end, String tags, String categories) {

        List<String> categoryNames = ListUtil.toList(categories.split(","));
        List<String> tagNames = ListUtil.toList(tags.split(","));

        Session session = null;
        try {
            session = openSession();
            String sql = CustomSQLUtil.get("com.arman.csb.modules.service.MyBlogService.getGroupBlogs");

            SQLQuery queryObject = session.createSQLQuery(sql);
            queryObject.setCacheable(false);
            queryObject.addEntity("BLOG_ENTRY", PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.blogs.model.BlogsEntry"));
            QueryPos qPos = QueryPos.getInstance(queryObject);
            qPos.add(categories.split(","));
            qPos.add(tags.split(","));
            
            
            //if no category or tag is specified omit this condition
            qPos.add(categoryNames.isEmpty() && tagNames.isEmpty());
            
            qPos.add(groupId);
            qPos.add(status);
            
            queryObject.setFirstResult(start);
            queryObject.setMaxResults(end - start);
            
            return (List<BlogsEntry>) queryObject.list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            closeSession(session);
        }
    }
}
