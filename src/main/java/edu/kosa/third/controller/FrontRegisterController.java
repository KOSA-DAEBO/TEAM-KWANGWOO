package edu.kosa.third.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.dao.LeaveDao;
import edu.kosa.third.dto.LeaveDto;
import edu.kosa.third.service.LeaveApplyServiceAction;

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FrontRegisterController() {
        super();
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
       	request.setCharacterEncoding("UTF-8");
    	
       	String requestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String urlcommand = requestURI.substring(contextPath.length());
    	

    	Action action=null;
    	ActionForward forward=null;
    	
    	
    	if(urlcommand.equals("/register.do")) {
    		//UI 제공 (서비스 객체가 필요없다)
    		forward = new ActionForward();
    		forward.setRedirect(false);
    		forward.setPath("/WEB-INF/views/register/register.jsp");

    	}else if(urlcommand.equals("/registerok.do")) {
    		//UI 제공 + 서비스 필요
    		action = null;
    		forward = action.execute(request, response); //request 클라이언트가 요청한 페이지당 1개씩 만들어지는 request객체
    	
    	}else if (urlcommand.equals("/leave.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/leave/leaveApplicationForm.jsp");
			
		} else if (urlcommand.equals("/leaveApply.do")) {
			action = new LeaveApplyServiceAction();
			forward = action.execute(request, response);
			
		} else if (urlcommand.equals("/leaveList.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/leave/leaveList.jsp");
			LeaveDao dao = new LeaveDao();
			List<LeaveDto> list = dao.selectAll();
			request.setAttribute("list", list);
		}else if(urlcommand.equals("/joinUsr.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/join/joinUsr.jsp");

		}else if(urlcommand.equals("/joinUsrOk.do")) { //UI + 로직
			action = new JoinOkServiceAction();
			forward = action.execute(request, response);//request 클라이언트가 요청한 페이지당 1개씩 만들어지는 request객체
		}
    
    	if(forward != null) {
    		if(forward.isRedirect()) { //true 페이지 재 요청 (location.href="페이지"
    			response.sendRedirect(forward.getPath());
    		}else { //기본적으로 forward ....
    			    //1. UI 전달된 경우
    			    //2. UI + 로직
    			RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
    			dis.forward(request, response);
    		}
    	}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
