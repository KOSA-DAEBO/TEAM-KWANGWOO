package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServiceAction implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        session.invalidate();// 세션 초기화


        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("/index.jsp"); //로그아웃 완료 메인 페이지로 이동
        return forward;
    }
}
