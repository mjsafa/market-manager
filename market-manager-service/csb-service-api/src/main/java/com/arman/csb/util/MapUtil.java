package com.arman.csb.util;

import com.arman.csb.modules.model.Customer;
import com.arman.csb.modules.service.CustomerLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 8/26/14
 * Time: 11:44 AM
 */
public class MapUtil extends com.liferay.portal.kernel.util.MapUtil {

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static Date getDate(Map<String, ?> map, String key, Date defaultValue) {
        long value = getLong(map, key, 0);
        if(value > 0){
            return new Date(value);
        }

        if (null != map.get(key)) {
            try {
                String dateString = getString(map, key, null);
                DateFormat format = new SimpleDateFormat(DATE_PATTERN);
                return format.parse(dateString);
            } catch (Exception e) {
            }
        }
        return defaultValue;
    }

    public static Date getDate(Map<String, ?> map, String key) {
        return getDate(map, key, null);
    }

    public static Customer getCustomer(Map<String, ?> map, String key) {
        Long customerId = getLong(map, key , 0);
        if(!customerId.equals(0L)){
            try {
                CustomerLocalServiceUtil.fetchCustomer(customerId);
            } catch (SystemException e) {}
        }
        return null;
    }


}
