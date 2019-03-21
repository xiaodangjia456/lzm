package com.source.root.framework.comm.pager;

/**
 * 鍒嗛〉鎻忚堪淇℃伅
 * 
 * @author dendy
 * 
 */
public class Pager {
	// 姣忎竴椤电殑鏄剧ず鏉℃暟
	private int showCount;

	// 鏌ヨ鐨勬暟鎹�鏉℃暟
	private int totalResult;
	// 鎬荤殑椤垫暟
	@SuppressWarnings("unused")
	private int totalPage;

	// 褰撳墠椤�
	private int currentPage;
	// 浠庣鍑犳潯寮�鑾峰彇鏁版嵁
	private int currentResult;
	// 涓嬩竴椤�
	private boolean havaNextPage;
	// 涓婁竴椤�
	private boolean havePrePage;
	// 绗竴椤�
	private boolean firstPage;
	// 鏈�悗涓�〉
	private boolean lastPage;

	public Pager() {
	}

	public Pager(String showCount, String currentPage, int totalResult) {
		if (showCount == null || "".equals(showCount)) {
			this.showCount = 10;
		} else {
			this.showCount = Integer.valueOf(showCount);
		}
		this.totalResult = totalResult;
		int p = this.totalResult / this.showCount;
		int _totalPage = this.totalResult % this.showCount == 0 ? p : p + 1;
		this.totalPage = _totalPage;

		if (currentPage == null || "".equals(currentPage)) {
			this.currentPage = 1;
		} else {
			this.currentPage = Integer.valueOf(currentPage);
			if (this.currentPage >= _totalPage) {
				this.currentPage = _totalPage;
			}
			if (this.currentPage < 1 || this.currentPage == -1) {
				this.currentPage = 1;
			}
		}
	}

	public int getShowCount() {
		return showCount;
	}

	public void setShowCount(int showCount) {
		this.showCount = showCount;
	}

	public int getTotalPage() {
		int p = this.totalResult / this.showCount;
		int _totalPage = this.totalResult % this.showCount == 0 ? p : p + 1;
		return _totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}

	public int getCurrentResult() {
		currentResult = (currentPage - 1) * showCount;
		return currentResult;
	}

	public void setCurrentResult(int currentResult) {
		this.currentResult = currentResult;
	}

	public boolean isHavaNextPage() {
		if (currentPage == this.getTotalPage()) {
			havaNextPage = false;
		} else {
			havaNextPage = true;
		}
		return havaNextPage;
	}

	public void setHavaNextPage(boolean havaNextPage) {
		this.havaNextPage = havaNextPage;
	}

	public boolean isHavePrePage() {
		if (currentPage == 1) {
			havePrePage = false;
		} else {
			havePrePage = true;
		}
		return havePrePage;
	}

	public void setHavePrePage(boolean havePrePage) {
		this.havePrePage = havePrePage;
	}

	public boolean isFirstPage() {
		if (currentPage == 1) {
			firstPage = false;
		} else {
			firstPage = true;
		}
		return firstPage;
	}

	public void setFirstPage(boolean firstPage) {
		this.firstPage = firstPage;
	}

	public boolean isLastPage() {
		if (currentPage == this.getTotalPage()) {
			lastPage = false;
		} else {
			lastPage = true;
		}
		return lastPage;
	}

	public void setLastPage(boolean lastPage) {
		this.lastPage = lastPage;
	}

}