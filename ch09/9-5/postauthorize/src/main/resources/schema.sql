CREATE TABLE account (
  username				VARCHAR(20) NOT NULL PRIMARY KEY,
  password				VARCHAR(128) NOT NULL,
  enabled				boolean	NOT NULL,
  admin					boolean	NOT NULL,
  user_uuid				VARCHAR(10) NOT NULL,
  last_name				VARCHAR(20) NOT NULL,
  department_code		VARCHAR(10) NOT NULL,
  department_manager	boolean NOT NULL
);

