CREATE TABLE room (
  room_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

CREATE TABLE equipment (
  equipment_id		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_id			INT NOT NULL,
  equipment_name 	VARCHAR(30) NOT NULL,
  equipment_count	INT NOT NULL,
  equipment_remarks	VARCHAR(100),
  FOREIGN KEY (room_id) REFERENCES room(room_id)
);

CREATE TABLE room_with_audit (
  room_id       	INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_name 		VARCHAR(30) NOT NULL,
  capacity			INT NOT NULL,
  created_by		VARCHAR(20),
  created_date		TIMESTAMP,
  last_modified_by	VARCHAR(20),
  last_modified_date	TIMESTAMP
);

