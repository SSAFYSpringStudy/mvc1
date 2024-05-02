package hello.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체 파라미터 조회]-start");

        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + ":" + request.getParameter(paramName)));
        //주의: paramName은 파라미터 키, request.getParameter(paramName)은 파라미터 값
        System.out.println("[전체 파라미터 조회]-end");
        System.out.println();

        System.out.println("[단일 파라미터 조회]-start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println("[단일 파라미터 조회]-end");
        System.out.println();

        System.out.println("[이름이 같은 복수 파라미터 조회]-start");
        //예를 들어 ?username=hello&age=20&username=hello2
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username = " + name);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회]-start");
        System.out.println();

        //웹브라우저에 아무것도 없으면 허전하니까 뭐라도 쓰자
        response.getWriter().write("ok");
    }
}
