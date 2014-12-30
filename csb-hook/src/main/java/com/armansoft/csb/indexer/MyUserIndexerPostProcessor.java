package com.armansoft.csb.indexer;

import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.model.User;

/**
 * Created with IntelliJ IDEA.
 * User: Mojtaba SAFAEIAN
 * Date: 12/29/14
 * Time: 10:43 PM
 */
public class MyUserIndexerPostProcessor extends BaseIndexerPostProcessor {
    @Override
    public void postProcessDocument(Document document, Object obj) throws Exception {
        User userEntity = (User) obj;
        String indexerUserTitle = "";
        try {
            indexerUserTitle = (String)userEntity.getExpandoBridge().getAttribute("mobile");
        } catch (Exception e) {
        }
        if (indexerUserTitle.length() > 0)
            document.addText(Field.KEYWORD_SEARCH, indexerUserTitle );
    }
}
