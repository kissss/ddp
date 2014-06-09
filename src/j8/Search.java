package j8;

public class Search {

	public int[][] xx;
	public int h;
	public int w;

	// 当前坐标
	public int cx;
	public int cy;
	// 移动的坐标
	public int dx;
	public int dy;

	public Search(int[][] xx) {
		super();
		this.xx = xx;
		this.h = xx.length;
		this.w = xx[0].length;
	}

	public Result find() {
		for (int x = 0; x < h; x++) {
			for (int y = 0; y < w; y++) {
				cx = x;
				cy = y;
				if (_find()) {
					return new Result(cx, cy, dx, dy);
				}
			}
		}
		return null;
	}

	public boolean _find() {
		for (Integer[] i : Rules.list) {
			int x0 = i[0] + cx;
			int y0 = i[1] + cy;

			int x1 = i[2] + cx;
			int y1 = i[3] + cy;

			int x2 = i[4] + cx;
			int y2 = i[5] + cy;

			if (isOut(x0, y0) || isOut(x1, y1) || isOut(x2, y2)) {
				continue;
			}
			if (xx[y0][x0] == xx[y1][x1] && xx[y0][x0] == xx[y2][x2]) {
				dx = x0;
				dy = y0;
				
				
				return true;
			}
		}
		return false;
	}

	public boolean isOut(int x, int y) {
		return x < 0 || x >= w || y < 0 || y >= h;
	}

	public static void main(String[] args) {

		int[][] x =
		{
		{ 3, 2, 2, 3, 8, 4, 3, 5 },
		{ 4, 4, 2, 3, 1, 4, 6, 6 },
		{ 7, 4, 6, 5, 3, 1, 4, 4 },
		{ 7, 7, 6, 6, 4, 1, 5, 6 },
		{ 1, 5, 8, 3, 5, 2, 6, 6 },
		{ 4, 2, 1, 4, 3, 7, 7, 4 },
		{ 7, 7, 6, 4, 6, 5, 7, 6 },
		{ 5, 7, 6, 6, 5, 7, 6, 5 } };

		Search search = new Search(x);

		Result results = search.find();
		if (results != null) {
			System.out.println(results);
		} else {
			System.err.println("没有找到");
		}

	}
}
