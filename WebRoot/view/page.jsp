<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	request.setAttribute("path",path);
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div class="row">
     <div class="col-md-12">
         <nav class="text-center">
             <ul class="pagination pagination">
                 
                <c:if test="${page.hasPreviousPage}">
                	<li>
                      <a href="${path}/${pageUrl}?pageNo=${page.currentPageNo-1}" aria-label="Previous">
                          <span aria-hidden="true">上一页</span>
                      </a>
                	</li>
				</c:if>
                <c:if test="${!page.hasPreviousPage}">
				 	<li>
                      <a aria-label="Previous">
                          <span aria-hidden="true">上一页</span>
                      </a>
	                 </li>
				</c:if>
		        <c:if test="${page.currentPageNo-2>0}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo-2}">${page.currentPageNo-2}</a></li>
				</c:if>
				<c:if test="${page.currentPageNo-1>0}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo-1}">${page.currentPageNo-1}</a></li>
				</c:if>
				<li class="active"><a>${page.currentPageNo}</a></li>
				<c:if test="${page.currentPageNo+1<=page.totalPageCount}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo+1}">${page.currentPageNo+1}</a></li>
				</c:if>
				<c:if test="${page.currentPageNo+2<=page.totalPageCount}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo+2}">${page.currentPageNo+2}</a></li>
				</c:if>
				<c:if test="${page.currentPageNo+3<=page.totalPageCount}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo+3}">${page.currentPageNo+3}</a></li>
				</c:if>
				<c:if test="${page.currentPageNo+4<=page.totalPageCount}">
					<li><a href="${path}/${pageUrl}?pageNo=${page.currentPageNo+4}">${page.currentPageNo+4}</a></li>
				</c:if>
		                 
		        <c:if test="${page.hasNextPage}">
		           	<li>
		                <a href="${path}/${pageUrl}?pageNo=${page.currentPageNo+1}" aria-label="Next">
		                    <span aria-hidden="true">下一页</span>
		                </a>
		            </li>
				</c:if>
				<c:if test="${!page.hasNextPage}">
				    <li>
		                <a aria-label="Next">
		                    <span aria-hidden="true">下一页</span>
		                </a>
		            </li>
				</c:if>
             </ul>
         </nav>
     </div>
 </div>
