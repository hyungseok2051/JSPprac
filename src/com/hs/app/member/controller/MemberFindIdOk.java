package com.hs.app.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.member.dao.MemberDAO;

public class MemberFindIdOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		ActionForward forward = new ActionForward();
		String memberEmail = req.getParameter("memberEmail");
		String memberPw = req.getParameter("memberPw");
		
		MemberDAO dao = new MemberDAO();
		req.setAttribute("memberId", dao.findId(memberEmail, memberPw));
		forward.setRedirect(false);
		forward.setPath("/app/member/showId.jsp");
		
		return forward;
	}
}
