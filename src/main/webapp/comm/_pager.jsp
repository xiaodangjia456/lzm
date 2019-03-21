<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="pagestr" align="center">
					<div class="remark_page">
						<label class="p_label_left">当前第${page.currentPage }页，共${page.totalPage }页，每页显示<select
							onchange="pageCount();" id="changeCount" name="changeCount" style="width: 40px;float: none;"><option
									value="10" <c:if test="${page.showCount==10 }">selected</c:if>>10</option>
								<option value="20"
									<c:if test="${page.showCount==20 }">selected</c:if>>20</option>
								<option value="30"
									<c:if test="${page.showCount==30 }">selected</c:if>>30</option></select>条，共${page.totalResult }条。
						</label>
					</div>
					<div class="butt_page">
						<div class="pages" onclick="_chooseCount();">跳转</div>
						<input type="text" id="chooseCount" name="chooseCount"
							class="pages" onchange="_chooseCount();"
							value="${page.currentPage }" style="width: 30px;">
						<div class="pages F_L_butt" onclick="_pageChange('last')">尾页</div>
						<div class="pages F_L_butt" onclick="_pageChange('down')">下一页</div>
						<c:choose>
							<c:when test="${page.totalPage==1 }">
								<div class="current" onclick="chooesPage(1);">1</div>
							</c:when>
							<c:when test="${page.totalPage==2 }">
								<c:choose>
									<c:when test="${page.currentPage==1 }">
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="current" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:otherwise>
										<div class="current" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${page.totalPage==3 }">
								<c:choose>
									<c:when test="${page.currentPage==1 }">
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="current" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==2 }">
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="current" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:otherwise>
										<div class="current" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${page.totalPage==4 }">
								<c:choose>
									<c:when test="${page.currentPage==1 }">
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="current" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==2 }">
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="current" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==3 }">
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="current" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:otherwise>
										<div class="current" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:otherwise>
								</c:choose>
							</c:when>
							<c:when test="${page.totalPage==5 }">
								<c:choose>
									<c:when test="${page.currentPage==1 }">
										<div class="pages" onclick="chooesPage(5);">5</div>
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="current" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==2 }">
										<div class="pages" onclick="chooesPage(5);">5</div>
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="current" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==3 }">
										<div class="pages" onclick="chooesPage(5);">5</div>
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="current" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==4 }">
										<div class="pages" onclick="chooesPage(5);">5</div>
										<div class="current" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
									<c:when test="${page.currentPage==5 }">
										<div class="current" onclick="chooesPage(5);">5</div>
										<div class="pages" onclick="chooesPage(4);">4</div>
										<div class="pages" onclick="chooesPage(3);">3</div>
										<div class="pages" onclick="chooesPage(2);">2</div>
										<div class="pages" onclick="chooesPage(1);">1</div>
									</c:when>
								</c:choose>
							</c:when>
							<c:when test="${page.totalPage>5 }">
								<c:choose>
									<c:when test="${page.currentPage==1 }">
										<div class="pages"
											onclick="chooesPage(${page.currentPage+4});">${page.currentPage+4}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+3});">${page.currentPage+3}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+2});">${page.currentPage+2}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+1});">${page.currentPage+1}</div>
										<div class="current"
											onclick="chooesPage(${page.currentPage});">${page.currentPage}</div>
									</c:when>
									<c:when test="${page.currentPage==2 }">
										<div class="pages"
											onclick="chooesPage(${page.currentPage+3});">${page.currentPage+3}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+2});">${page.currentPage+2}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+1});">${page.currentPage+1}</div>
										<div class="current"
											onclick="chooesPage(${page.currentPage});">${page.currentPage}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-1});">${page.currentPage-1}</div>
									</c:when>
									<c:when
										test="${page.currentPage>2 && page.currentPage<=page.totalPage-2}">
										<div class="pages"
											onclick="chooesPage(${page.currentPage+2});">${page.currentPage+2}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage+1});">${page.currentPage+1}</div>
										<div class="current"
											onclick="chooesPage(${page.currentPage});">${page.currentPage}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-1});">${page.currentPage-1}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-2});">${page.currentPage-2}</div>
									</c:when>
									<c:when test="${page.currentPage==page.totalPage-1 }">
										<div class="pages"
											onclick="chooesPage(${page.currentPage+1});">${page.currentPage+1}</div>
										<div class="current"
											onclick="chooesPage(${page.currentPage});">${page.currentPage}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-1});">${page.currentPage-1}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-2});">${page.currentPage-2}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-3});">${page.currentPage-3}</div>
									</c:when>
									<c:when test="${page.currentPage==page.totalPage }">
										<div class="current"
											onclick="chooesPage(${page.currentPage});">${page.currentPage}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-1});">${page.currentPage-1}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-2});">${page.currentPage-2}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-3});">${page.currentPage-3}</div>
										<div class="pages"
											onclick="chooesPage(${page.currentPage-4});">${page.currentPage-4}</div>
									</c:when>
								</c:choose>
							</c:when>
						</c:choose>
						<div class="pages F_L_butt" onclick="_pageChange('up')">上一页</div>
						<div class="pages F_L_butt" onclick="_pageChange('first')">首页</div>

					</div>
				</div>