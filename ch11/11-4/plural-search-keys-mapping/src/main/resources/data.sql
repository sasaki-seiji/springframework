INSERT INTO meeting_room VALUES ('001', '幹部用会議室', 10);
INSERT INTO meeting_room VALUES ('002', '大会議室', 30);
INSERT INTO meeting_room VALUES ('003', '会議室A', 15);

INSERT INTO meeting_room VALUES ('A-001', 'MR-01', 10);
INSERT INTO meeting_room VALUES ('A-002', 'MR-02', 20);
INSERT INTO meeting_room VALUES ('A-003', 'MR-03', 30);

INSERT INTO meeting_room VALUES ('B-001', 'CR-01', 80);
INSERT INTO meeting_room VALUES ('B-002', 'CR-02', 150);
INSERT INTO meeting_room VALUES ('B-003', 'CR-03', 200);

INSERT INTO reservable_room VALUES ('A-001', '2019-01-12');
INSERT INTO reservable_room VALUES ('A-001', '2019-01-13');
INSERT INTO reservable_room VALUES ('A-001', '2019-01-14');
INSERT INTO reservable_room VALUES ('A-002', '2019-01-12');
INSERT INTO reservable_room VALUES ('A-002', '2019-01-13');

INSERT INTO reservation VALUES ('001', 'A-001', '2019-01-12', '13:00:00', '15:00:00');
INSERT INTO reservation VALUES ('002', 'A-001', '2019-01-12', '15:00:00', '17:00:00');
INSERT INTO reservation VALUES ('003', 'A-002', '2019-01-13', '10:00:00', '12:00:00');
INSERT INTO reservation VALUES ('004', 'A-002', '2019-01-13', '13:00:00', '15:00:00');
