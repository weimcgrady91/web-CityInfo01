package com.wei.cityinfo.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BasicsServlet extends HttpServlet {
    public abstract void forwardError(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;

    public abstract void forwardSuccess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
}
