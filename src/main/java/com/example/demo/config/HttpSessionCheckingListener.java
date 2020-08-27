//package com.example.demo.config;
//
//import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSessionEvent;
//import javax.servlet.http.HttpSessionListener;
//
//@WebListener
//public class HttpSessionCheckingListener implements HttpSessionListener{
// 
//    public void sessionCreated(HttpSessionEvent sessionEve) {
//		System.out.println(sessionEve.getSession().isNew());
//		String visitorcheck=(String)sessionEve.getSession().getId();
//		System.out.println(visitorcheck);
//		  if(sessionEve.getSession().isNew()){
////	            execute(sessionEve);
//	            System.out.println("세션생성");
//	        }
//
//
//         //등록되어있는 빈을 사용할수 있도록 설정해준다
//    }
//
//    @Override
//    public void sessionDestroyed(HttpSessionEvent hse) {
//      System.out.println("세션 종료");
//    }
//}
//
//
