/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.home_bookkeeping.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.com.codefire.home_bookkeeping.dao.DocDaoImpl;
import ua.com.codefire.home_bookkeeping.dao.IDocDao;
import ua.com.codefire.home_bookkeeping.dao.models.Doc;

/**
 *
 * @author Igor Gayvan
 */
@WebServlet("/add")
public class DocAddServlet extends HttpServlet {

    private final IDocDao dao = new DocDaoImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("confirm") != null) {
            Map<String, String> errors = new HashMap<>();
            Doc doc = new Doc();

            fillFields(request, doc, errors);

            if (errors.isEmpty()) {
                dao.add(doc);

                response.sendRedirect("index");
                return; // WARNING!!! MUST BE HERE!!!
            }
            request.getRequestDispatcher("WEB-INF/views/docAdd.jsp").forward(request, response);
        } else if (request.getParameter("cancel") != null) {
//            request.setAttribute("docs", dao.getAll());
//            request.getRequestDispatcher("WEB-INF/views/docList.jsp").forward(request, response);
            response.sendRedirect("index");
        } else if (request.getParameter("clear") != null) {
            request.getRequestDispatcher("WEB-INF/views/docAdd.jsp").forward(request, response);
        }
    }

    private void fillFields(HttpServletRequest request, Doc doc, Map<String, String> errors) {
        request.setAttribute("errors", errors);

        String param = request.getParameter("docAmount");
        if (param == null || param.trim().isEmpty()) {
            errors.put("errAmount", "Input amount for the doc!");
        } else {
            doc.setDocAmount(new BigDecimal(param.replaceAll(",", "")));
        }

        param = request.getParameter("docDate");
        try {
            doc.setDocDate(new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.GERMAN).parse(param));
        } catch (ParseException ex) {
            Logger.getLogger(DocAddServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        param = request.getParameter("docNote");
        doc.setDocNote(param);

//        param = request.getParameter("isIncome");
        doc.setIsIncome(request.getParameter("isIncome") != null);
    }
}
