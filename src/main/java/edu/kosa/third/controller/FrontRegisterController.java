package edu.kosa.third.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kosa.third.action.Action;
import edu.kosa.third.action.ActionForward;
import edu.kosa.third.service.*;

@WebServlet("*.do")
public class FrontRegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontRegisterController() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURI.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;

		if (urlcommand.equals("/register.do")) {
			// UI 제공 (서비스 객체가 필요없다)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/register/register.jsp");

		} else if (urlcommand.equals("/registerok.do")) {
			// UI 제공 + 서비스 필요
			action = null;
			forward = action.execute(request, response); // request 클라이언트가 요청한 페이지당 1개씩 만들어지는 request객체

		} else if (urlcommand.equals("/leave.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/leave/leaveApplicationForm.jsp");

		} else if (urlcommand.equals("/leaveApply.do")) {
			action = new LeaveApplyServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/leaveList.do")) {
			action = new LeaveListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/itemList.do")) {
			action = new ItemListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/joinCustomer.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/join/joinCustomer.jsp");

		} else if (urlcommand.equals("/joinCustomerOk.do")) {
			action = new JoinCustomerOkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/leaveApprove.do")) {
			action = new LeaveApproveServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/joinEmp.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/join/joinEmp.jsp");

		} else if (urlcommand.equals("/joinEmpOk.do")) {
			action = new JoinEmpOkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/addItem.do")) {
			action = new AddItemServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/loginCustomer.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/login/loginCustomer.jsp");

		} else if (urlcommand.equals("/loginCustomerOk.do")) {
			action = new LoginCustomerOkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/loginEmp.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/login/loginEmp.jsp");

		} else if (urlcommand.equals("/loginEmpOk.do")) {
			action = new LoginEmpOkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/updateItem.do")) {
			action = new UpdateItemServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/deleteItem.do")) {
			action = new DeleteItemServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/buyItem.do")) {
			action = new BuyItemServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/idDuplChk.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/join/idChk.jsp");

		} else if (urlcommand.equals("/idDuplOk.do")) {
			action = new IdDuplicateOkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/empDetail.do")) {
			action = new DetailEmpInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/leaveDelete.do")) {
			action = new LeaveDeleteServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/productList.do")) {
			action = new ProductListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/logout.do")) {
			action = new LogoutServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/commuteEmp.do")) {
			action = new CommuteCalendarServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/commuteEmpChk.do")) {
			action = new CommuteEmpServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/commuteEmpChkOk.do")) {
			action = new CommuteEmpChkServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/manageEmpInfo.do")) {
			action = new ManageEmpInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/empList.do")) {
			action = new TotalEmpInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/insertDept.do")) {
			action = new AddDeptServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/deleteDept.do")) {
			action = new DeleteDeptServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/detailProduct.do")) {
			action = new ProductInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/addProduct.do")) {
			action = new AddProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/goAddProduct.do")) {
			action = new GetItemServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/updateDept.do")) {
			action = new UpdateDeptServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/deleteProduct.do")) {
			action = new DeleteProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/updateProduct.do")) {
			action = new UpdateProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/customList.do")) {
			action = new CustomProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/detailCustomProduct.do")) {
			action = new CustomProductDetailServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/buyProduct.do")) {
			action = new BuyProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/customItemList.do")) {
			action = new CustomItemListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/buyDiyProduct.do")) {
			action = new BuyDyiProductServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/commuteAdmin.do")) {
			action = new CommuteCalendarAdminServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/leaveModify.do")) {
			action = new LeaveModifyServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/salList.do")) {
			action = new SalListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/salApply.do")) {
			action = new SalApplyServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/updateUsrInfo.do")) {
			action = new UpdateEmpInfoServiceAction();
			forward = action.execute(request, response);
			
		} else if (urlcommand.equals("/deptMenu.do")) {
			action = new DeptMenuServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/deleteUsrInfo.do")) {
			action = new DeleteUsrInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/customDetail.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/usrinfo/showCustomInfo.jsp");
			
		} else if (urlcommand.equals("/updateManageEmpInfo.do")) {
			action = new UpdateManageEmpInfoServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/salPayStub.do")) {
			action = new SalPayStubServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/customInfoList.do")) {
			action = new CustomerInfoListServiceAction();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/customManage.do")) {
			action = new ManageCustomInfoServiceAction();
			forward = action.execute(request, response);
			
		} else if(urlcommand.equals("/deleteCustom.do")) {
			action = new DeleteCustomServiceAction();
			forward = action.execute(request, response);
			
		} else if(urlcommand.equals("/changeCustomInfo.do")) {
			action = new ChangeCustomInfoServiceAction();
			forward = action.execute(request, response);
			
		} else if (urlcommand.equals("/departureCustom.do")) {
			action = new DepartureCustomServiceAction();
			forward = action.execute(request, response);
			
		} 
		
		if (forward != null) {
			if (forward.isRedirect()) { // true 페이지 재 요청 (location.href="페이지"
				response.sendRedirect(forward.getPath());
			} else { // 기본적으로 forward ....
						// 1. UI 전달된 경우
						// 2. UI + 로직
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
