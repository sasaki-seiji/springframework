package com.example.set_if_pg;

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

        	MeetingRoom meetingRoom = new MeetingRoom();
        	meetingRoom.setRoomId("A-001");
        	meetingRoom.setRoomName("MR-01-updated");
        	meetingRoom.setCapacity(0);
        	boolean updated = meetingRoomService.update(meetingRoom);
        	System.out.println("updated(A-001, MR-01-updated, 0): " + updated);
        	meetingRoom = meetingRoomService.findOne("A-001");
        	System.out.println("findOne(A-001): " + meetingRoom);
        	
        	meetingRoom.setRoomId("A-002");
        	meetingRoom.setRoomName("MR-02-updated");
        	meetingRoom.setCapacity(25);
        	updated = meetingRoomService.update(meetingRoom);
        	System.out.println("updated(A-002, MR-02-updated, 25): " + updated);
        	meetingRoom = meetingRoomService.findOne("A-002");
        	System.out.println("findOne(A-002): " + meetingRoom);
    	}
    }
}
