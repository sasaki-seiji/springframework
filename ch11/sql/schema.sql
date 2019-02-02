DROP TABLE meeting_room;

CREATE TABLE meeting_room (
  room_id       VARCHAR(36) NOT NULL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

DROP TABLE reservable_room;

CREATE TABLE reservable_room (
	room_id			VARCHAR(36) NOT NULL,
	reserved_date	DATE NOT NULL,
	PRIMARY KEY (room_id, reserved_date),
	FOREIGN KEY (room_id) REFERENCES meeting_room(room_id) 
);

DROP TABLE meeting_room_serial;

CREATE TABLE meeting_room_serial (
  room_id       SERIAL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);