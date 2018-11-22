/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 *
 * https://leetcode.com/problems/merge-intervals/description/
 *
 * algorithms
 * Medium (33.69%)
 * Total Accepted:    265.5K
 * Total Submissions: 787.9K
 * Testcase Example:  '[[1,3],[2,6],[8,10],[15,18]]'
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into
 * [1,6].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 */
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list = new ArrayList<>();
        if(intervals.size() == 0)
            return list;
        if(intervals.size() == 1) {
            list.add(intervals.get(0));
            return list;
        }            
        Comparator<Interval> comptr = (Interval i1, Interval i2) -> 
            i2.start - i1.start;
        Collections.sort(intervals, comptr);
        Stack<Interval> stack = new Stack<>();
        for(int i = 0; i < intervals.size(); i++)
            stack.push(intervals.get(i));
        while(!stack.isEmpty()) {
            Interval i1 = stack.pop();            
            if(!stack.isEmpty()) {
                Interval i2 = stack.pop();
                if(i1.end < i2.start) {
                    list.add(i1);
                    stack.push(i2);
                } else if(i1.end >= i2.start && i1.end < i2.end) {
                    Interval v = new Interval(i1.start, i2.end);
                    stack.push(v);
                } else {
                   stack.push(i1); 
                }                   
            } else {
                list.add(i1);    
            }                
        }
        return list;
    }
}
