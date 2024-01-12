package com.leetcode.bytedance;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author milindeyu
 * @Date 2023/12/16 4:45 下午
 * @Version 1.0
 */
public class Demo2276 {

    static class CountIntervals {

        private final TreeSet<int[]> container;
        private final Comparator<int[]> comparator;
        int count = 0;

        public CountIntervals() {
            this.comparator = (a, b) -> {
                if (a[1] < b[0]) {
                    return -1;
                } else if (a[0] > b[1]) {
                    return 1;
                } else {
                    return 0;
                }
            };
            this.container = new TreeSet<>(comparator);
        }

        public void add(int left, int right) {
            int[] nums = {left, right};
            if (container.add(nums)) {
                count += right - left + 1;
            } else {
                int[] floor;
                int[] cur = nums;
                while ((floor = container.floor(cur)) != null && comparator.compare(floor, nums) == 0) {
                    cur = new int[]{Math.min(floor[0], cur[0]), Math.max(floor[1], cur[1])};
                    container.remove(floor);
                    count -= floor[1] - floor[0] + 1;
                }
                container.add(cur);
                count += cur[1] - cur[0] + 1;
            }
        }

        public int count() {
            return count;
        }
    }

    public static void main(String[] args) {
        Demo2276.CountIntervals demo2276 = new Demo2276.CountIntervals();
        int[][] nums = {{365,897},{261,627},{781,884},{},{},{},{328,495},{224,925},{228,464},{},{416,451},{},{747,749},{},{},{},{},{},{740,757},{51,552},{20,896},{459,712},{},{383,670},{},{701,924},{},{},{392,591},{},{},{935,994},{},{},{},{398,525},{335,881},{243,517},{},{995,1000},{15,335},{430,490},{376,681},{},{733,841},{},{},{603,633},{974,978},{466,786},{241,753},{259,887},{},{},{410,514},{173,300},{},{},{},{805,957},{272,805},{723,858},{113,118},{},{426,987},{318,997},{741,978},{},{},{},{},{701,992},{},{},{562,766},{987,1000},{},{929,929},{},{},{926,931},{913,975},{},{930,962},{707,914},{688,757},{},{430,433},{452,683},{794,919},{799,991},{},{},{},{658,731},{},{328,686},{998,999},{},{455,938},{981,988},{},{92,699},{311,690},{916,920},{},{213,339},{605,961},{719,902},{},{},{},{129,833},{},{844,926},{940,956},{148,182},{},{163,885},{},{},{},{532,886},{},{},{},{306,906},{},{},{948,963},{},{116,853}};
        StringBuilder content = new StringBuilder("[");
        for (int i = 0; i < nums.length; i++) {
            int[] num = nums[i];
            if (num.length == 0) {
                int count = demo2276.count();
                content.append(count);
            } else {
                demo2276.add(num[0], num[1]);
                content.append("null");
            }
            if (i != nums.length - 1) {
                content.append(",");
            }
        }
        content.append("]");
        System.out.println(content);
    }
}
