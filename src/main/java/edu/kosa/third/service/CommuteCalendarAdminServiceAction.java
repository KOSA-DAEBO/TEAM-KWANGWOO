package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.CommuteDao;
import edu.kosa.third.dto.EmpDto;
import org.json.simple.JSONArray;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommuteCalendarAdminServiceAction  implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        EmpDto dto = (EmpDto)session.getAttribute("login");

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);

        if(dto.isRole()){
            CommuteDao dao = new CommuteDao();
            JSONArray jsonArray = dao.calendarAdmin(dto);

            //POST 방식으로 JsonArray 전달
            request.setAttribute("jsonArray", jsonArray);

            forward.setPath("/WEB-INF/views/commute/commuteAdmin.jsp"); //관리자 출결확인
            return forward;
        }
        forward.setPath("commuteEmpChk.do"); //관리자 출결확인
        return forward;


    }
}
