# algorithms

## 一些经典的算法与数据结构学习心得
### 1.两种排序算法（归并排序与快速排序）
### 2.链表类问题总结：
+ 147.对链表进行插入排序
+ 148.排序链表：对于k个有序链表的排序，需要用到小顶堆PriorityQueue
+ 141.环形链表（判断是否有环）
+ 142.环形链表 II (寻找入环的第一个节点)
+ 206.反转链表（迭代法与递归法）：记住迭代法在循环中在新建next节点
+ 24.两两交换链表中的节点：递归和迭代法都要记住，迭代需要利用dummy节点
+ 2.两数相加：要注意两个链表长度不一样的情况以及最后还存在一位进位的情况
+ 445.两数相加 II：利用栈完成，记住输出需要逆向
### 3.DFS/BFS问题总结
+ 46.全排列：典型的dfs问题，几个注意点，递归的返回条件，以及visited数组的使用
+ 47.全排列 II：在上一问的基础之上进行剪枝，首先需要排序让重复数字在一起。如果上一个数字没有用到过就跳过。
+ 17.电话号码的字母组合：依然是回溯问题，这次要回溯的是每个数字对应的字母表，而不是数字idx这点要明确。
+ 78.子集：对于每一个数有两种选择：选或者不选；需要分别进入下一层dfs。
+ 90.子集 II：递归的方法和子集相同，首先排序数组，在不选择该数字的时候，需要用while循环遍历到不重复的位置。可以这样理解，如果需要选择这个数字，那么不影响下面重复数字的选择；如果不选择，那么这个数字相同的数字都不可以选，否则就会产生重复的子集。
+ 39.组合总和：本质上和子集相同，不同点在于每个数可以选择无数次，所以选择该数字时，dfs下一层idx无需+1。
+ 40.组合总和II：去重的方法与子集II相同，在选取该数字的情况下，dfs之后需要把重复的数字跳过，再进行不选择的情况。
+ 216.组合总和III：和前两问相似，记住回溯的写法和终止条件。
+ 377.组合总和IV：与组合总和类似，但是可以包含重复但顺序不同的组合。和零钱兑换类似，可以用dp来优化dfs。
