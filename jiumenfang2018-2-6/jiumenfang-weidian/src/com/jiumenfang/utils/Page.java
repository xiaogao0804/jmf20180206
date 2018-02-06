package com.jiumenfang.utils;

 
import java.util.List; 

/**本分页工具类使用方法（2016-2）：
<SCRIPT type="text/javascript">
  		function fenye(page){
  			document.getElementById("page").value = page;
  			document.forms[0].submit();
  		}
</SCRIPT>

<form action="action名称" method="post">
  <input type="hidden" id="page" name="currentPage"/>
  按姓名查询：<input type="text" name="mohu" value="${mohu}"/>
<input type="submit" value="查询"/>
</form>

<table>
    <tr>
    	<td >
    	第${page.currentPage}/${page.pageCount}页
  			<a onclick="fenye(1)">首页</a>
  			<a onclick="fenye(${page.previousPage})">上一页</a>
  			<a onclick="fenye(${page.nextPage})">下一页</a>
  			<a onclick="fenye(${page.pageCount})">尾页</a>
		</td>
    </tr>
</table>


Servlet要声明三个变量和getter、setter:
private Page page;
private String currentPage;
private String mohu;
list方法：
//获得列表记录数
Integer count = service.count(mohu);
page = new Page(currentPage,count,"3");
list = service.pageList(mohu,page);

dao查询方法需要page对象，然后使用两个方法：page.getStartRecord() 和page.getPageSize()
不需要你这样计算：（currentPage-1）*pageSize
 *
 * @param <T>
 */
public final class Page<T> {

	public static final int DEFAULT_PAGE_SIZE = 3;

	private int count;
	private int pageSize;
	private int pageCount;
	private int currentPage;
	private int previousPage;
	private int nextPage;
	private int startRecord;
	private int endRecord;
	private List<T> list;

	public Page(String current, int count, String pageSize) {
		this.count = count;
		init(current, pageSize);
	}

	private void init(String current, String size) {
		initPageSize(size);
		initPageCount();
		initCurrentPage(current);
		initPreviousPage();
		initNextPage();
		initStartRecord();
		initEndRecord();
	}

	private void initPageSize(String size) {
		if (size == null || size.trim().isEmpty()) {
			pageSize = DEFAULT_PAGE_SIZE;
			return;
		}
		try {
			pageSize = Integer.parseInt(size);
		} catch (Exception e) {
			pageSize = DEFAULT_PAGE_SIZE;
		}
	}

	private void initEndRecord() {
		endRecord = startRecord + pageSize - 1;
		if (endRecord > count) {
			endRecord = count;
		}
	}

	private void initStartRecord() {
		startRecord = (currentPage - 1) * pageSize;
		if (startRecord < 0) {
			startRecord = 0;
		}
		if (startRecord > count) {
			startRecord = count;
		}
	}

	private void initNextPage() {
		nextPage = currentPage + 1;
		if (nextPage > pageCount) {
			nextPage = pageCount;
		}
	}

	private void initPreviousPage() {
		previousPage = currentPage - 1;
		if (previousPage < 1) {
			previousPage = 1;
		}
	}

	private void initCurrentPage(String current) {
		if (current == null || current.trim().isEmpty()) {
			currentPage = 1;
			return;
		}
		try {
			currentPage = Integer.parseInt(current);
		} catch (Exception e) {
			currentPage = 1;
		}
		if (currentPage < 1) {
			currentPage = 1;
			return;
		}
		if (currentPage > pageCount) {
			currentPage = pageCount;
		}
	}

	private void initPageCount() {
		pageCount = count / pageSize;
		if (count % pageSize != 0) {
			pageCount++;
		}
	}

	public int getCount() {
		return count;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPreviousPage() {
		return previousPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public int getStartRecord() {
		return startRecord;
	}

	public int getEndRecord() {
		return endRecord;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	
}
