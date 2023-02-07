<%@page import="gist.daos.BlogDao"%>
<%@page import="gist.beans.Blog"%>
<%@page import="gist.beans.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="gist.daos.CategoryDao"%>
<div class="col-lg-4">
            <div class="sidebar">
              <div class="row">
                <div class="col-lg-12">
                  <div class="sidebar-item search">
                    <form id="search_form" name="gs" method="GET" action="#">
                      <input type="text" name="q" class="searchText" placeholder="type to search..." autocomplete="on">
                    </form>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="sidebar-item recent-posts">
                    <div class="sidebar-heading">
                      <h2>Recent Posts</h2>
                    </div>
                    <div class="content">
                      <ul>
                          <%
                          ArrayList<Blog> recentBlogs = new BlogDao().findRecentPost(3);
                          for(Blog blog : recentBlogs) {
                              if(blog.getStatus().equalsIgnoreCase("approved"))
                              {
                                  
                          %>
                          <li><a href="viewBlogDetail.jsp?id=<%=blog.getId()%>">
                                <h5><%=blog.getTitle()%></h5> 
                          <span><%=blog.getDate()%> </span>
                        </a></li>
                        <%}
}%>
                       </ul>
                    </div>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="sidebar-item categories">
                    <div class="sidebar-heading">
                      <h2>Categories</h2>
                    </div>
                    <div class="content">
                        <%
                        String catId= request.getParameter("catid");
                        int catid = catId==null ? 0 : Integer.parseInt(catId);
                         %>
                      <ul>
                          <li> <a href="index.jsp"  class="<%=catid==0?"btn btn-primary text-white": ""%>">- All Categories</a> </li>
                        
                          <% 
                              CategoryDao cd = new CategoryDao();
                              ArrayList<Category> catlist = cd.findAll();
                              for(Category c : catlist) {%>
                              <li> <a href="index.jsp?catid=<%=c.getId()%>"  class="<%=catid==c.getId()?"btn btn-primary text-white": ""%>">- <%=c.getName()%></a> </li>
                        <% }%>
                        </ul>
                    </div>
                  </div>
                </div>
                <div class="col-lg-12">
                  <div class="sidebar-item tags">
                    
                    
                  </div>
                </div>
              </div>
            </div>
          </div>