package com.javaex.ex02;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao = new AuthorDao();
		
		//작가등록
		authorDao.authorInsert("이문열", "경북 영양");
		
		//작가등록
		authorDao.authorInsert("박경리", "경상남도 통영");
		
		//작가등록
		authorDao.authorInsert("유시민", "17대 국회의원");
		
		List<AuthorVo> authorList = authorDao.authorSelect();
		for(int i=0; i<authorList.size(); i++) {
			AuthorVo vo = authorList.get(i);
			System.out.println(vo.getAuthorId() +", "+vo.getAuthorName()+","+ vo.getAuthorDesc());
			
			
		}

		
		
		
		//작가수정
		//authorDao.authorUpdate(2, "박경리(수정)", "경상남동 통영(수정)");
				
		//작가 삭제
		//authorDao.authorDelete(1);
		
		
		
		
		
		
		
		
		
	}

}