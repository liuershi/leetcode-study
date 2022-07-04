package com.leetcode.bytedance;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author milindeyu
 * @Date 2022/6/23 12:07 上午
 * @Version 1.0
 */
public class Demo30_1 {

    int size;
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
    }

    public static void main(String[] args) {
        Demo30_1 demo30_1 = new Demo30_1();
        String[] strings = {"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
        String s = "pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
        System.out.println(demo30_1.findSubstring(s, strings));
    }
}
