package com.arman.csb.modules.service.impl;

import com.arman.csb.modules.service.base.InstanceLocalServiceBaseImpl;

/**
 * The implementation of the instance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.arman.csb.modules.service.InstanceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.arman.csb.modules.service.base.InstanceLocalServiceBaseImpl
 * @see com.arman.csb.modules.service.InstanceLocalServiceUtil
 */
public class InstanceLocalServiceImpl extends InstanceLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.arman.csb.modules.service.InstanceLocalServiceUtil} to access the instance local service.
     */
}
