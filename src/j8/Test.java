package j8;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Test {
	public static void main(String[] args) throws Exception {

		List<MemoryImage> list = new ArrayList<MemoryImage>();
		MemoryImage m1 = new MemoryImage(ImageIO.read(new FileInputStream("E:\\MyEclipse workspace\\ddp\\image\\1.jpg")));

		MemoryImage m2 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\00.jpg")));
		MemoryImage m3 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\01.jpg")));
		MemoryImage m4 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\02.jpg")));
		MemoryImage m5 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\03.jpg")));
		MemoryImage m6 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\04.jpg")));
		MemoryImage m7 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\05.jpg")));
		MemoryImage m8 = new MemoryImage(ImageIO.read(new FileInputStream("F:\\1\\06.jpg")));
		list.add(m2);
		list.add(m3);
		list.add(m4);
		list.add(m5);
		list.add(m6);
		list.add(m7);
		list.add(m8);
		for (MemoryImage m : list) {
			System.out.println(m1.equals(m));
		}
	}
}
