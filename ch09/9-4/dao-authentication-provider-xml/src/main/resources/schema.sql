CREATE TABLE account (
  username		VARCHAR(20) NOT NULL PRIMARY KEY,
  password		VARCHAR(128) NOT NULL,
  enabled		boolean	NOT NULL,
  admin			boolean	NOT NULL
);

