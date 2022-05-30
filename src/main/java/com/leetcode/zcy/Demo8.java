package com.leetcode.zcy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 贪心算法实现给定一些会议，求出合理安排能最多会议的安排
 *
 * @Author milindeyu
 * @Date 2022/3/30 10:45 下午
 * @Version 1.0
 */
public class Demo8 {

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start +  "," + end;
        }
    }

    /**
     * 自定义比较器，会议结束时间早的排前面
     */
    class MeetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.end - o2.end;
        }
    }

    /**
     *
     * @param meetings 所有会议
     * @param startTime 当天会议最早开始时间（默认早上六点）
     * @return
     */
    public Meeting[] arrange(Meeting[] meetings, int startTime) {
        // 规律，按会议结束时间早的先安排
        Arrays.sort(meetings, new MeetingComparator());

        List<Meeting> readyMeeting = new ArrayList<>();
        for (Meeting meeting : meetings) {
            if (meeting.start >= startTime) {
                startTime = meeting.end;
                readyMeeting.add(meeting);
            }
        }
        return readyMeeting.toArray(new Meeting[0]);
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();
        Meeting[] meetings = {
                new Meeting(8, 9),
                new Meeting(10, 14),
                new Meeting(7, 8),
                new Meeting(9, 11),
                new Meeting(13, 15),
                new Meeting(18, 20),
                new Meeting(14, 24),
        };

        System.out.println(Arrays.toString(demo8.arrange(meetings, 6)));
    }
}
