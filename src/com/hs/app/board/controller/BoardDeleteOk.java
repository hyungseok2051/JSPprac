package com.hs.app.board.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hs.app.action.Action;
import com.hs.app.action.ActionForward;
import com.hs.app.board.dao.BoardDAO;
import com.hs.app.files.dao.FilesDAO;
import com.hs.app.files.vo.FilesVO;

public class BoardDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		
		String saveFolder = "C:\\jsp2_hds\\workspace\\board_mvc\\WebContent\\app\\upload";
		FilesDAO fDao = new FilesDAO();
		BoardDAO bDao = new BoardDAO();
		ActionForward forward = new ActionForward();
		
		int boardNum = Integer.parseInt(req.getParameter("boardNum"));
		for(FilesVO file : fDao.getFiles(boardNum)) {
			File f = new File(saveFolder, file.getFileName());
			if(f.exists()) {
				f.delete();
			}
		}
		
		fDao.deleteFiles(boardNum);
		bDao.deleteBoard(boardNum);
		
		forward.setRedirect(false);
		forward.setPath("/board/BoardListOk.bo");
		
		return forward;
	}

}
