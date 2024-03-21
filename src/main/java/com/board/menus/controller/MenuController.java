package com.board.menus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.menus.domain.MenuVo;
import com.board.menus.mapper.MenuMapper;

@Controller
@RequestMapping("/Menus")
public class MenuController {
	
	@Autowired
	private  MenuMapper  menuMapper;
	
	// 메뉴 목록 조회  /Menus/List
	@RequestMapping("/List")   
	public   String   list( Model model ) {
		// 조회한결과를 ArrayList 로 돌려준디
		List<MenuVo> menuList = menuMapper.getMenuList();
		// 조회 결과를 넘겨준다 ( Model )
		model.addAttribute( "menuList", menuList );
		
		return "menus/list";
	}
	
	
	// 메뉴 입력받는 화면  /Menus/WriteForm
	//@RequestMapping("/Menus/WriteForm")
	@RequestMapping("/WriteForm")   // /Menus/WriteForm
	public   String   writeForm() {
		return "menus/write";  // /WEB-INF/views/ + menus/write + .jsp`
	}
	
	/*
	// 메뉴 저장
	// /Menus/Write?menu_id=MENU02&menu_name=JSP&menu_seq=2
	//@RequestMapping("/Menus/Write")
	@RequestMapping("/Write")  
	//public   String   write( 
	// 		String menu_id, String menu_name, int menu_seq) { 
	 // 인식안됨(error)     menu_id 를 찾을 수 없다
	public   String   write( MenuVo  menuVo, Model model ) {   // Vo 로 작업해야한다
		// 넘어온 데이터를 db 에 저장하고		
		menuMapper.insertMenu( menuVo );
		// menuMapper.insertMenu(menu_id, menu_name, menu_seq); // error

		
		return "redirect:/Menus/List"; 
	}
	*/
	
	@RequestMapping("/Write") 
	@ResponseBody
	public String write( MenuVo menuVo, Model model ) {
		
		// 추가
		menuMapper.insertMenu( menuVo );
		
		String html = "<script>";
		html += "alert('추가되었습니다');";
		html += "location.href='/Menus/List';";
		html += "</script>";
		return html;
	}
	
	/*
	// 메뉴삭제
	@RequestMapping("/Delete")
	public String delete( MenuVo menuVo, Model model ) {
		
		// 삭제
		menuMapper.deleteMenu( menuVo );

		return "redirect:/Menus/List";
	}
	*/
	// 삭제완료 알림창 기능 추가
	@RequestMapping("/Delete")
	@ResponseBody
	public String delete( MenuVo menuVo, Model model ) {
		
		// 삭제
		menuMapper.deleteMenu( menuVo );
		
		String html = "<script>";
		html += "alert('삭제되었습니다');";
		html += "location.href='/Menus/List';";
		html += "</script>";
		return html;
	}
	
	
}






