package com.blood;

import java.io.IOException;


import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/BloodListServlet")
public class BloodListServlet extends HttpServlet {
     
    private static final long serialVersionUID = 1L;
 
    BloodListService service = new BloodListService();
     
    /**
     * 方法选择
     */
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if ("add".equals(method)) {
            add(req, resp);
        } else if ("del".equals(method)) {
            del(req, resp);
        } else if ("update".equals(method)) {
            update(req, resp);
        } else if ("getbloodlistbyid".equals(method)) {
            getBloodListById(req, resp);
        } else if ("getbloodlistbyname".equals(method)) {
            getBloodListByName(req, resp);
        } else if ("list".equals(method)) {
            list(req, resp);
        }
    }
 
    /**
     * 添加
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String volume = req.getParameter("volume");
        String date = req.getParameter("date");
        BloodList bloodlist = new BloodList(name, type, volume, date);
         
        //添加后消息显示
        if(service.add(bloodlist)) {
            req.setAttribute("message", "添加成功");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        } else {
            req.setAttribute("message", "献血人名称重复，请重新录入");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }
     
    /**
     * 全部
     * @param req
     * @param resp
     * @throws ServletException
     */
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        List<BloodList> bloodlists = service.list();
        req.setAttribute("bloodlists", bloodlists);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
 
    /**
     * 通过ID得到BloodList
     * @param req
     * @param resp
     * @throws ServletException
     */
    private void getBloodListById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        BloodList bloodlist = service.getBloodListById(id);
        req.setAttribute("bloodlist", bloodlist);
        req.getRequestDispatcher("detail2.jsp").forward(req,resp);
    }
 
    /**
     * 通过名字查找
     * 跳转至删除
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void getBloodListByName(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        BloodList bloodlist = service.getBloodListByName(name);
        if(bloodlist == null) {
            req.setAttribute("message", "查无此人！");
            req.getRequestDispatcher("del.jsp").forward(req,resp);
        } else {
            req.setAttribute("bloodlist", bloodlist);
            req.getRequestDispatcher("detail.jsp").forward(req,resp);
        }
    }
     
    /**
     * 删除
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void del(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        service.del(id);
        req.setAttribute("message", "删除成功！");
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }
     
    /**
     * 修改
     * @param req
     * @param resp
     * @throws IOException
     * @throws ServletException
     */
    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String type = req.getParameter("type");
        String volume = req.getParameter("volume");
        String date = req.getParameter("date");
        BloodList bloodlist = new BloodList(id, name, type, volume, date);
         
        service.update(bloodlist);
        req.setAttribute("message", "修改成功");
        req.getRequestDispatcher("BloodListServlet?method=list").forward(req,resp);
    }
     
}