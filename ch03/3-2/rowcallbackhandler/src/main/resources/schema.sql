CREATE TABLE room (
  room_id       VARCHAR(10) NOT NULL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

CREATE TABLE equipment (
  equipment_id		VARCHAR(10) NOT NULL PRIMARY KEY,
  room_id			VARCHAR(10) NOT NULL,
  equipment_name 	VARCHAR(30) NOT NULL,
  equipment_count	INT NOT NULL,
  equipment_remarks	VARCHAR(100),
  FOREIGN KEY (room_id) REFERENCES room(room_id)
);
