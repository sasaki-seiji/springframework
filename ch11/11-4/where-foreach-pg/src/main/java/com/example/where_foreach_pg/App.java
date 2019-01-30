package com.example.where_foreach_pg;

import java.util.ArrayList;
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

        	List<String> roomIds = new ArrayList<String>();
        	roomIds.add("001");
        	roomIds.add("A-002");
        	roomIds.add("B-003");
        	
        	List<MeetingRoom> meetingRooms = meetingRoomService.findByRoomIds(roomIds);
        	System.out.println("findByRoomIds(001, A-002, B-003): " + meetingRooms);
    	}
    }
}
