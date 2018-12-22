DROP TABLE equipment;
DROP TABLE room;
CREATE TABLE room (
  room_id       SERIAL PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

CREATE TABLE equipment (
  equipment_id		SERIAL PRIMARY KEY,
  room_id			INT NOT NULL,
  equipment_name 	VARCHAR(30) NOT NULL,
  equipment_count	INT NOT NULL,
  equipment_remarks	VARCHAR(100),
  FOREIGN KEY (room_id) REFERENCES room(room_id)
);
