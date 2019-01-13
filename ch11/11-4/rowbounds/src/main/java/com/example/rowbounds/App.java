package com.example.rowbounds;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
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

        	RowBounds rowBounds = new RowBounds(5, 5);
        	List<MeetingRoom> meetingRooms = meetingRoomService.findAll(rowBounds);
        	System.out.println("findAll(RowBounds(5,5)): " + meetingRooms);
    	}
    }
}
