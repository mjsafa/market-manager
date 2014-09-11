package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.base.MyBlogLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.service.PortletServiceUtil;
import com.liferay.portlet.blogs.model.BlogsEntry;
import com.liferay.portlet.blogs.model.impl.BlogsEntryImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * The implementation of the my blog local service.
 * <p/>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.MyBlogLocalService} interface.
 * <p/>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.MyBlogLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.MyBlogLocalServiceUtil
 */
public class MyBlogLocalServiceImpl extends MyBlogLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.MyBlogLocalServiceUtil} to access the my blog local service.
     */

    public List<BlogsEntry> findGroupEntries(long  companyId, long groupId, int status, int start, int end, String tags, String categories) {

        String[] categoryNames = (!StringUtils.isBlank(categories)) ? categories.split(",") : ArrayUtils.EMPTY_STRING_ARRAY;
        String[] tagNames = (!StringUtils.isBlank(tags)) ? tags.split(",") : ArrayUtils.EMPTY_STRING_ARRAY;

        Session session = null;
        try {

            SessionFactory  sessionFactory = (SessionFactory) PortalBeanLocatorUtil.locate("liferaySessionFactory");

            session = blogsEntryPersistence.openSession();
            //session = sessionFactory.openSession();

            String sql = CustomSQLUtil.get("com.arman.csb.modules.service.MyBlogService.getGroupBlogs");

            SQLQuery queryObject = session.createSQLQuery(sql);
            queryObject.setCacheable(false);
            queryObject.addEntity("BlogsEntry",PortalClassLoaderUtil.getClassLoader().loadClass("com.liferay.portlet.blogs.model.impl.BlogsEntryImpl"));
            QueryPos qPos = QueryPos.getInstance(queryObject);
            qPos.add(categories.split(","));
            qPos.add(tags.split(","));

            //if no category or tag is specified omit this condition
            qPos.add(categoryNames.length == 0 && tagNames.length == 0);

            qPos.add(groupId);
            qPos.add(status);
            qPos.add(companyId);

            queryObject.setFirstResult(start);
            queryObject.setMaxResults(end - start);

            return (List<BlogsEntry>) queryObject.list();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            blogsEntryPersistence.closeSession(session);
        }
    }
}
