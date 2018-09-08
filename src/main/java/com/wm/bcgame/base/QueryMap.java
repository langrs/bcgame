package com.wm.bcgame.base;

import java.util.HashMap;

public class QueryMap extends HashMap<String, Object> {
    /**
     *
     * queryMap只能在getOne和getList时使用，queryMap会自动将null变为""
     */
    private static final long serialVersionUID = 1L;

    @Override
    public Object put(String key, Object value) {
        if (value == null) {
            value = "";
        }
        return super.put(key, value);
    }
}
