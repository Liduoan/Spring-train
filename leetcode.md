# 算法训练

## 20211202

### [406. 根据身高重建队列](https://leetcode-cn.com/problems/queue-reconstruction-by-height/)

难度中等1062

假设有打乱顺序的一群人站成一个队列，数组 `people` 表示队列中一些人的属性（不一定按顺序）。每个 `people[i] = [hi, ki]` 表示第 `i` 个人的身高为 `hi` ，前面 **正好** 有 `ki` 个身高大于或等于 `hi` 的人。

请你重新构造并返回输入数组 `people` 所表示的队列。返回的队列应该格式化为数组 `queue` ，其中 `queue[j] = [hj, kj]` 是队列中第 `j` 个人的属性（`queue[0]` 是排在队列前面的人）。

----------------

这道题目的特点是有两种数据彼此交杂

渔（套路）：一般这种数对，还涉及排序的，根据第一个元素正向排序，根据第二个元素反向排序，或者根据第一个元素反向排序，根据第二个元素正向排序，往往能够简化解题过程。

```java
class Solution {
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
        for(int[] cur : people) {
            res.add(cur[1],cur);
        }

        return res.toArray(new int[res.size()][]);
    }
}
```

我们主要看两个地方，一个是排序处理

这种多级别的排序 其实是先把尾部排好序 再把前面排好序

而使用`Arrays.sort`的方式是我们需要使用`Comparator`进行处理的

需要记住一个地方

后减前 递减排序  前减后 递增排序



### [238. 除自身以外数组的乘积](https://leetcode-cn.com/problems/product-of-array-except-self/)

难度中等989

给你一个长度为 *n* 的整数数组 `nums`，其中 *n* > 1，返回输出数组 `output` ，其中 `output[i]` 等于 `nums` 中除 `nums[i]` 之外其余各元素的乘积。

提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。

说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。

进阶：
你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，

------

这道题目很有趣

我们关注的点在于如何相乘？怎么相乘？

比如`[2,3,4,5]`

```jade
坐标   乘积
1     1		3	4	5 
2	  2		1	4	5
3     2		3	1	5
4     2		3	4	1
```

所以说，这里的处理就是每个位置的乘法

```java
class Solution {
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
```

这个题目我们主要是分析清楚结果是什么构成的。

我的感觉是 存在重复计算量，那么就往重复计算的地方去看，如何完成整体的算法

今天先这样练练手哈，找点感觉



















