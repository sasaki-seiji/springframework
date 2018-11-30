CREATE TABLE account (
  username		VARCHAR(20) NOT NULL PRIMARY KEY,
  password		VARCHAR(128) NOT NULL,
  enabled		boolean	NOT NULL,
  admin			boolean	NOT NULL
);

CREATE TABLE message (
	id		INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	message	VARCHAR(256) NOT NULL
--	message	VARCHAR(256) 
);