package com.example.update_pg;

import java.util.List;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.AppConfig;
import com.example.domain.model.MeetingRoom;
import com.example.domain.repository.MeetingRoomService;

public class App 
{
    public static void main( String[] args )
    {
    	try(ConfigurableApplicationContext context 
       			= new AnnotationConfigApplicationContext(AppConfig.class)) {
        	MeetingRoomService meetingRoomService 
        		= context.getBean("meetingRoomService", MeetingRoomService.class);

        	List<MeetingRoom> list = meetingRoomService.findAll();
        	System.out.println("initially: " + list);

        	MeetingRoom meetingRoom = new MeetingRoom();
        	meetingRoom.setRoomId("002");
        	meetingRoom.setRoomName("コンファレンスルーム");
        	meetingRoom.setCapacity(50);
        	
        	boolean updated = meetingRoomService.update(meetingRoom);
        	System.out.println("update(" + meetingRoom + ") returns " + updated);
        	
        	list = meetingRoomService.findAll();
        	System.out.println("finally: " + list);
    	}
    }
}
