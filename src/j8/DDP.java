package j8;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import win32.Mouse;
import win32.Rect;
import win32.User32;

public class DDP {
	/* 棋盘区域坐标 */
	private static final int X = 269;
	private static final int Y = 95;
	private static final int W = 384;
	private static final int H = 384;
	private static List<MemoryImage> memoryImageList = new ArrayList<MemoryImage>();

	public static void main(String[] args) throws Exception {

		User32 user32 = User32.INSTANCE;

		int[][] intArr = new int[8][8];

		int hwnd = user32.FindWindowA(null, "对对碰角色版");
		Rect r = new Rect();
		user32.GetWindowRect(hwnd, r);

		Rectangle rg = new Rectangle(r.left, r.top, r.right - r.left, r.bottom - r.top);
		try {
			// BufferedImage image = ImageIO.read(new FileInputStream("E://1.jpg"));
			BufferedImage image = new Robot().createScreenCapture(rg);
			MemoryImage memoryImage = new MemoryImage(image);
			// 得到 操作的区域
			MemoryImage operationArea = memoryImage.copy(X, Y, W, H);
			operationArea.write("F://1.jpg");
			// MemoryImage operationArea = new MemoryImage(image);

			MemoryImage[][] imgArr = new MemoryImage[8][8];
			Qtype qType = new Qtype();

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					imgArr[i][j] = operationArea.copy(j * 48 + 19, i * 48 + 19, 10, 10);
					intArr[i][j] = qType.getQtypeId(imgArr[i][j]);
				}
			}
			Search search = new Search(intArr);
			Result result = search.find();

			imgClick(hwnd, result);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	private static void imgClick(int hwnd, Result result) {
		Mouse.click(hwnd, X + result.x1 * 48, Y + result.y1 * 48);
		Mouse.click(hwnd, X + result.x2 * 48, Y + result.y2 * 48);
	}

	public static synchronized void addSet(MemoryImage mem) {
		if (memoryImageList.size() != 0) {
			boolean flag = false;
			for (MemoryImage m : memoryImageList) {
				// 表示有重复的
				if (mem.equals(m)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				memoryImageList.add(mem);
			}
		} else {
			memoryImageList.add(mem);
		}
	}

	public static Integer getImageNo(List<MemoryImage> list, MemoryImage m) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(m)) {
				return i + 1;
			}
		}
		return null;
	}

	public static boolean getImageNo(MemoryImage m1, MemoryImage m2) {
		return m1.equals(m2);
	}
}
