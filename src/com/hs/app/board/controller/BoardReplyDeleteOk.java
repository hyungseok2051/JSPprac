package com.hs.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardReplyDAO;

public class BoardReplyDeleteOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		BoardReplyDAO dao = new BoardReplyDAO();
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		
		dao.deleteReply(replyNum);
		return null;
	}
}
