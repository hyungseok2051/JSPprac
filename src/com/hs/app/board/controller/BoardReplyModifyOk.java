package com.hs.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardReplyDAO;
import com.hs.app.board.vo.BoardReplyVO;

public class BoardReplyModifyOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyDAO dao = new BoardReplyDAO();
		BoardReplyVO vo = new BoardReplyVO();
		
		int replyNum = Integer.parseInt(req.getParameter("replyNum"));
		String replyContent = req.getParameter("replyContent");
		
		vo.setReplyNum(replyNum);
		vo.setReplyContent(replyContent);
		
		dao.updateReply(vo);
		
		return null;
	}
}
