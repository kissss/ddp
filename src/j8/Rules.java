package j8;

import java.util.ArrayList;
import java.util.List;

public class Rules {

	// 为了简单，3个坐标，分别存在 int[] 的 0~5 元素中
	// 当然你也可以弄个坐标类，然后把3个坐标类存入，这个随便。

	// 直接public 省的get方法
	public static final List<Integer[]> list = new ArrayList<Integer[]>();

	static {

		list.add(new Integer[] { 0, 1, 0, -1, 0, -2 });// 1
		list.add(new Integer[] { 0, -1, 0, 1, 0, 2 });// 2
		list.add(new Integer[] { -1, 0, 0, -1, 0, -2 });// 3
		list.add(new Integer[] { -1, 0, 0, 1, 0, 2 });// 4
		list.add(new Integer[] { 1, 0, 0, -1, 0, -2 });// 5
		list.add(new Integer[] { 1, 0, 0, 1, 0, 2 });// 6
		list.add(new Integer[] { 1, 0, 0, -1, 0, 1 });// 7
		list.add(new Integer[] { -1, 0, 0, -1, 0, 1 });// 8
		list.add(new Integer[] { 1, 0, -1, 0, -2, 0 });// 9
		list.add(new Integer[] { -1, 0, 1, 0, 2, 0 });// 10
		list.add(new Integer[] { 0, 1, -1, 0, -2, 0 });// 11
		list.add(new Integer[] { 0, 1, 1, 0, 2, 0 });// 12
		list.add(new Integer[] { 0, -1, -1, 0, -2, 0 });// 13
		list.add(new Integer[] { 0, -1, 1, 0, 2, 0 });// 14
		list.add(new Integer[] { 0, -1, -1, 0, 1, 0 });// 15
		list.add(new Integer[] { 0, 1, -1, 0, 1, 0 });// 16

	}

}
