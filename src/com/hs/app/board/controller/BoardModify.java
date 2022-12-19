package com.hs.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardDAO;

public class BoardModify implements Action{
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		ActionForward forward = new ActionForward();
		
		BoardDAO bDao = new BoardDAO();
		
		req.setAttribute("board", bDao.getDetail(boardNum));
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardModify.jsp");
		
		return forward;
	}
}
