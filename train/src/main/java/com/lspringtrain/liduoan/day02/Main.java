package com.lspringtrain.liduoan.day02;

import java.util.*;

/**
 * @author liduoan
 * @date 2021年12月02日 16:15
 */
public class Main {

    public static void main(String[] args) {
        int[][] res = new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Main main = new Main();
        main.reconstructQueue(res);
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        LinkedList<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }

        return res.toArray(new int[res.size()][]);

    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
        }
        // 下三角完成处理
        int pre = 1;
        for (int i = 1; i < nums.length; i++) {
            pre *= nums[i - 1];
            res[i] = pre;
        }
        // 上三角处理
        pre = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            pre *= nums[i+1];
            res[i] *= pre;
        }
        return res;

    }
}
