package com.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author milindeyu
 * @Date 2023/11/23 8:34 下午
 * @Version 1.0
 */
public class Demo1410 {

    /**
     * key : 关键字
     * value ： strs[0] = 关键字长度， strs[1] = 关键字替换内容
     */
    Map<String, String[]> dict = new HashMap<>(6);
    public String entityParser(String text) {
        initDict();
        StringBuilder content = new StringBuilder();
        int index = 0;
        while (index < text.length()) {
            String[] replace = null;
            if (text.charAt(index) == '&' && (replace = check(index, text)) != null) {
                content.append(replace[1]);
                index += Integer.parseInt(replace[0]);
            } else {
                content.append(text.charAt(index++));
            }
        }
        return content.toString();
    }

    private String[] check(int start, String text) {
        for (Map.Entry<String, String[]> entry : dict.entrySet()) {
            if (entry.getKey().length() + start <= text.length()) {
                boolean check = doCheck(start, text, entry.getKey());
                if (check) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private boolean doCheck(int start, String text, String checkText) {
        for (int i = 0; i < checkText.length(); i++) {
            if (text.charAt(start + i) != checkText.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private void initDict() {
        dict.put("&quot;", new String[]{"6", "\""});
        dict.put("&apos;", new String[]{"6", "'"});
        dict.put("&amp;", new String[]{"5", "&"});
        dict.put("&gt;", new String[]{"4", ">"});
        dict.put("&lt;", new String[]{"4", "<"});
        dict.put("&frasl;", new String[]{"7", "/"});
    }
}
