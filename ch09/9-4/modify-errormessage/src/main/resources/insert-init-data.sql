--  enabled
--         account_non_expired
--                credentials_non_expired
--                       account_non_locked
--                              admin   
INSERT INTO account VALUES ('guest', '$2a$10$IGr6WwwMYT9yjGMHZygOYeCF2POdgqrYV2YlY2n0UhLx7M6lTqigm', 
	TRUE,  TRUE,  TRUE,  TRUE,  FALSE, 'U001', '(guest)');
INSERT INTO account VALUES ('admin', '$2a$10$uyXIQe9yhzo1kt08DcXRfeIqax43O2cD6puA5626fnslCVFcjEo.S', 
	TRUE,  TRUE,  TRUE,  TRUE,  TRUE, 'U002', '(admin)');
INSERT INTO account VALUES ('disabled', '$2a$10$za2id1t3HP2/hH2LRdsDNObDKilwF0AW77OuG7By7MrmLUutn54Va', 
	FALSE, TRUE,  TRUE,  TRUE,  FALSE, 'U003', '(disabled)');
INSERT INTO account VALUES ('account-expired', '$2a$10$d6QT0tGhQgB2vCRD3B1Qy.8GvusCwtZt8P.pf0kN0wkI.1B7fhe7m', 
	TRUE,  FALSE, TRUE,  TRUE,  FALSE, 'U004', '(account-expired)');
INSERT INTO account VALUES ('credentials-expired', '$2a$10$JKWGZ5cBZKP/oVyZqOIX1uKNdOPkWfV/DHthlut5SFl4B4xl9dKCG', 
	TRUE,  TRUE,  FALSE, TRUE,  FALSE, 'U005', '(credentials-expired)');
INSERT INTO account VALUES ('account-locked', '$2a$10$x/0h5P5qqn38dnLjNXpp/.sXTkldY40z6tb.7LFmcxRhMOWJsFfbC', 
	TRUE,  TRUE,  TRUE,  FALSE, FALSE, 'U006', '(account-locked)');
	