DROP TABLE meeting_room;

CREATE TABLE meeting_room (
  room_id       VARCHAR(36) NOT NULL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);


DROP TABLE meeting_room_serial;

CREATE TABLE meeting_room_serial (
  room_id       SERIAL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);