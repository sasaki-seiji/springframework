CREATE TABLE meeting_room (
  room_id       VARCHAR(10) NOT NULL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

CREATE TABLE reservable_room (
	room_id			VARCHAR(10) NOT NULL,
	reserved_date	DATE NOT NULL,
	PRIMARY KEY (room_id, reserved_date),
	FOREIGN KEY (room_id) REFERENCES meeting_room(room_id) 
);