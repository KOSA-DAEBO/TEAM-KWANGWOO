package edu.kosa.third.service;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.CommuteDao;
import edu.kosa.third.dto.EmpDto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommuteEmpChkServiceAction  implements Action {
    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        String commuteStatus = request.getParameter("commuteButton");
        HttpSession session = request.getSession();
        EmpDto dto = (EmpDto)session.getAttribute("login");
        CommuteDao dao = new CommuteDao();

        if(commuteStatus.equals("출근 하기")){
            dao.goCommute(dto); // insert + emp.empStatus update

            dto.setEmpStatus(true);//empstatus 출퇴근 세션 변경
            session.removeAttribute("login");
            session.setAttribute("login",dto);
        }else{
            dao.leaveCommute(dto); // 퇴근시간 update + emp.empStatus update

            dto.setEmpStatus(false); //empstatus 출퇴근 세션 변경
            session.removeAttribute("login");
            session.setAttribute("login",dto);
        }

        ActionForward forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath("commuteEmp.do"); //emp 출근 캘린더 페이지
        return forward;
    }
}
