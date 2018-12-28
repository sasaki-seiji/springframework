CREATE TABLE room (
  room_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL
);

CREATE TABLE room_with_version (
  room_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_name 	VARCHAR(30) NOT NULL,
  capacity		INT NOT NULL,
  version		INT NOT NULL
);

CREATE TABLE equipment (
  equipment_id		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  room_id			INT NOT NULL,
  equipment_name 	VARCHAR(30) NOT NULL,
  equipment_count	INT NOT NULL,
  equipment_remarks	VARCHAR(100),
  FOREIGN KEY (room_id) REFERENCES room_with_version(room_id)
);

