package io.quarkus.qe.undertow;
import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@WebServlet("/hello")
public class UNDERTOW_1657_1671 extends HttpServlet {

    @Override
    @Produces(MediaType.TEXT_PLAIN)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
        resp.getWriter().write("hi everyone!");
    }

}