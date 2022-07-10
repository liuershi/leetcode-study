package com.leetcode.bytedance;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author milindeyu
 * @Date 2022/6/23 12:07 上午
 * @Version 1.0
 */
public class Demo30_1 {

    /*int size;
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rsp = new ArrayList<>();
        if (s == null || words == null || (size = words.length) == 0) return rsp;
        for (String word : words) {
            if (!s.contains(word)) return rsp;
        }
        int wLen = words[0].length();
        if (s.length() < wLen * size) return rsp;
        Set<String> matcherItem = new HashSet<>();
        traceBack(words, new LinkedList<>(), matcherItem, new HashSet<>());
        // 遍历拼接的字符串，判断是否出现在原始字符串中
        for (String content : matcherItem) {
            int index = s.indexOf(content);
            while (index != -1) {
                rsp.add(index);
                index = s.indexOf(content, index + content.length());
            }
        }
        return rsp;
    }

    private void traceBack(String[] words, LinkedList<String> path, Set<String> matcherItem, Set<Integer> set) {
        if (path.size() == size) {
            matcherItem.add(String.join("", path));
            return;
        }
        for (int i = 0; i < size; i++) {
            if (set.contains(i)) continue;
            set.add(i);
            String word = words[i];
            path.addLast(word);
            traceBack(words, path, matcherItem, set);
            path.removeLast();
            set.remove(i);
        }
    }*/


    /**
     * 使用哈希表基于滑动窗口实现
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> rsp = new ArrayList<>();
        int size;
        if (s == null || words == null || (size = words.length) == 0) return rsp;
        int wLen = words[0].length();
        int sLen = s.length();
        if (sLen < wLen * size) return rsp;
        Map<String, Long> wMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            wMap.put(words[i], wMap.getOrDefault(words[i], 0L) + 1);
        }
        int wLenSum = wLen * size;
        for (int i = 0; i <= sLen - wLenSum; i++) {
            Map<String, Long> sMap = getWords(s, i, wLen, size);
            if (check(wMap, sMap)) rsp.add(i);
        }
        return rsp;
    }

    private boolean check(Map<String, Long> wMap, Map<String, Long> sMap) {
        for (Map.Entry<String, Long> entry : wMap.entrySet()) {
            if (sMap.get(entry.getKey()) == null || !sMap.get(entry.getKey()).equals(entry.getValue())) return false;
        }
        return true;
    }

    private Map<String, Long> getWords(String s, int begin, int wLen, int size) {
        String[] words = new String[size];
        int i = 0;
        while (i < size) {
            words[i++] = s.substring(begin, begin + wLen);
            begin += wLen;
        }
        return Stream.of(words).collect(Collectors.groupingBy(item -> item, Collectors.counting()));
    }

    public static void main(String[] args) {
        Demo30_1 demo30_1 = new Demo30_1();
        String s = "wordgoodgoodgoodbestword";
        String[] words= {"word","good","best","good"};
        System.out.println(demo30_1.findSubstring(s, words));
    }

    public static void main(String[] args) {
        Demo30_1 demo30_1 = new Demo30_1();
        String[] strings = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        System.out.println(demo30_1.findSubstring(s, strings));
    }
}
