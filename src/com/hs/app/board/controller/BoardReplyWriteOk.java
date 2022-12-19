package com.hs.app.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardReplyDAO;
import com.hs.app.board.vo.BoardReplyVO;

public class BoardReplyWriteOk implements Action{
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		BoardReplyDAO dao = new BoardReplyDAO();
		BoardReplyVO vo = new BoardReplyVO();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		String memberId = (String)req.getSession().getAttribute("sessionId");
		String replyContent = req.getParameter("replyContent");
		
		vo.setBoardNum(boardNum);
		vo.setMemberId(memberId);
		vo.setReplyContent(replyContent);
		
		dao.insertReply(vo);
		
		return null;
	}
}
