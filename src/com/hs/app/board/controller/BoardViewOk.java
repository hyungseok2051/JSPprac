package com.hs.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardDAO;
import com.hs.app.files.dao.FilesDAO;

public class BoardViewOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		BoardDAO bDao = new BoardDAO();
		FilesDAO fDao = new FilesDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		req.setAttribute("board", bDao.getDetail(boardNum));
		req.setAttribute("files", fDao.getFiles(boardNum));
		
		bDao.updateReadCount(boardNum);
		
		forward.setRedirect(false);
		forward.setPath("/app/board/boardView.jsp");
		
		return forward;
	}
}










