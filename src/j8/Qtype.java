package j8;

import java.util.ArrayList;
import java.util.List;

public class Qtype {

	List<MemoryImage> list = new ArrayList<MemoryImage>();

	public int getQtypeId(MemoryImage mem) {
		for (int i = 0; i < list.size(); i++) {
			// ��ʾ����ͬ��
			if (mem.equals(list.get(i))) {
				return i + 1;
			}
		}
		// û����ͬ��
		list.add(mem);
		return list.size();
	}
}
