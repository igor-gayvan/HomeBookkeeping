/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.home_bookkeeping.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.home_bookkeeping.dao.DocDaoImpl;
import ua.com.codefire.home_bookkeeping.dao.IDocDao;

/**
 *
 * @author Igor Gayvan
 */
@WebServlet("/index")
public class DocListServlet extends HttpServlet {

    private final IDocDao dao = new DocDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String param = request.getParameter("remove");
        if (existParam(param)) {
            dao.remove(Integer.parseInt(param));
        }

        param = request.getParameter("edit");
        if (existParam(param)) {
            request.setAttribute("doc", dao.getByDocId(Integer.parseInt(param)));

            request.getRequestDispatcher("WEB-INF/views/docEdit.jsp").forward(request, response);
        }

        request.setAttribute("docs", dao.getAll());
        request.getRequestDispatcher("WEB-INF/views/docList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("add") != null) {
            request.getRequestDispatcher("WEB-INF/views/docAdd.jsp").forward(request, response);
        } else if (request.getParameter("refresh") != null) {
            request.setAttribute("docs", dao.getAll());
            request.getRequestDispatcher("WEB-INF/views/docList.jsp").forward(request, response);
        } else if (request.getParameter("findByNote") != null) {
            request.setAttribute("docs", dao.getByDocNote(request.getParameter("textFindNote")));
            request.getRequestDispatcher("WEB-INF/views/docList.jsp").forward(request, response);
        }
    }

    private boolean existParam(String param) {
        return param != null && !param.trim().isEmpty() && param.matches("\\d+");
    }

}
