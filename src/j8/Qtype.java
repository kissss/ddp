package j8;

import java.util.ArrayList;
import java.util.List;

public class Qtype {

	List<MemoryImage> list = new ArrayList<MemoryImage>();

	public int getQtypeId(MemoryImage mem) {
		for (int i = 0; i < list.size(); i++) {
			// 表示有相同的
			if (mem.equals(list.get(i))) {
				return i + 1;
			}
		}
		// 没有相同的
		list.add(mem);
		return list.size();
	}
}
