package edu.kosa.third.utils;

import edu.kosa.third.dto.CustomerDto;
import edu.kosa.third.dto.EmpDto;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginCheckFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter
            (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        EmpDto login = (EmpDto) req.getSession().getAttribute("login");
        CustomerDto loginCustomer =  (CustomerDto) req.getSession().getAttribute("Customerlogin");

        if(login==null && isEmpChkUrl(req)){
            request.getRequestDispatcher("loginEmp.do").forward(request, response);
        }else if(loginCustomer==null && isCustomerChkUrl(req)){
            request.getRequestDispatcher("loginCustomer.do").forward(request, response);
        }else {
            chain.doFilter(request, response);
        }
    }

    //로그인 제외 uri
    private boolean isEmpChkUrl(HttpServletRequest req) {
        //true : 검사
        String uri = req.getRequestURI();
        //cp/bbs/list.do
        String cp = req.getContextPath();
        uri=uri.substring(cp.length());
        // /bbs/list.do

        String []empUrl = { //직원 로그인 체크 해야할 URL
                "/leave.do",
                "/leaveApply.do",
                "/leaveList.do",
                "/itemList.do",
                "/leaveApprove.do",
                "/addItem.do",
                "/updateItem.do",
                "/deleteItem.do",
                "/buyItem.do",
                "/empDetail.do",
                "/leaveDelete.do",
                "/productList.do",
                "/customDetail.do",
                "/commuteEmp.do",
                "/commuteEmpChk.do",
                "/commuteEmpChkOk.do",
                "/deptMenu.do",
                "/manageEmpInfo.do",
                "/empList.do"

        };

        for(String str:empUrl) {
            if(str.lastIndexOf("/**")!=-1) {
                str=str.substring(0,str.lastIndexOf("**"));
                if(uri.indexOf(str)==0) {
                    return true;
                }
            }else if(uri.equals(str)) {
                return true;
            }
        }

        return false;
    }

    private boolean isCustomerChkUrl(HttpServletRequest req) {
        //true : 검사
        String uri = req.getRequestURI();
        //cp/bbs/list.do
        String cp = req.getContextPath();
        uri=uri.substring(cp.length());
        // /bbs/list.do

        String []customerUrl = { //고객 로그인 체크 해야할 URL

        };
        if(uri.length()<=1) {
            return true;
        }

        for(String str:customerUrl) {
            if(str.lastIndexOf("/**")!=-1) {
                str=str.substring(0,str.lastIndexOf("**"));
                if(uri.indexOf(str)==0) {
                    return true;
                }
            }else if(uri.equals(str)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}