DROP TABLE equipment;
DROP TABLE room;
DROP TABLE counter;
DROP TABLE room_with_audit;

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

CREATE TABLE counter (
  id		SERIAL PRIMARY KEY,
  count		INT NOT NULL,
  version	INT NOT NULL
);

CREATE TABLE room_with_audit (
  room_id       	SERIAL PRIMARY KEY,
  room_name 		VARCHAR(30) NOT NULL,
  capacity			INT NOT NULL,
  created_by		VARCHAR(20),
  created_date		TIME WITH TIME ZONE,
  last_modified_by	VARCHAR(20),
  last_modified_date	TIME WITH TIME ZONE
);


