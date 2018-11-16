CREATE TABLE account (
  username		VARCHAR(40) NOT NULL PRIMARY KEY,
  password		VARCHAR(128) NOT NULL,
  enabled		boolean	NOT NULL,
  account_non_expired	boolean NOT NULL,
  credentials_non_expired	boolean NOT NULL,
  account_non_locked	boolean NOT NULL,
  admin			boolean	NOT NULL,
  user_uuid		VARCHAR(20) NOT NULL,
  last_name		VARCHAR(40) NOT NULL
);

