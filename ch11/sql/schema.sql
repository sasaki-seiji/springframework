DROP TABLE meeting_room;

CREATE TABLE meeting_room (
  room_id       VARCHAR(10) NOT NULL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);