INSERT INTO room(room_name, capacity) VALUES ('幹部用会議室', 10);
INSERT INTO room(room_name, capacity) VALUES ('セミナールーム', 30);
INSERT INTO room(room_name, capacity) VALUES ('カンファレンスルーム', 100);
INSERT INTO room(room_name, capacity) VALUES ('room-101', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-102', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-103', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-104', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-105', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-106', 6);
INSERT INTO room(room_name, capacity) VALUES ('room-107', 6);
INSERT INTO room(room_name, capacity) VALUES ('room-108', 6);
INSERT INTO room(room_name, capacity) VALUES ('room-201', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-202', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-203', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-204', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-205', 8);
INSERT INTO room(room_name, capacity) VALUES ('room-206', 6);
INSERT INTO room(room_name, capacity) VALUES ('room-207', 6);
INSERT INTO room(room_name, capacity) VALUES ('room-208', 6);

INSERT INTO equipment(room_id, equipment_name, equipment_count, equipment_remarks)
	 VALUES (1, 'テレビ会議システム', 1, NULL);
INSERT INTO equipment(room_id, equipment_name, equipment_count, equipment_remarks)
	 VALUES (1, 'プロジェクタ', 1, '部屋備え付けです');
INSERT INTO equipment(room_id, equipment_name, equipment_count, equipment_remarks)
	 VALUES (2, 'シンクライアント', 10, NULL);
INSERT INTO equipment(room_id, equipment_name, equipment_count, equipment_remarks)
	 VALUES (2, 'プロジェクタ', 5, '移動可能です');
INSERT INTO equipment(room_id, equipment_name, equipment_count, equipment_remarks)
	 VALUES (2, 'ホワイトボード', 6, '移動可能です');

INSERT INTO room_with_version(room_name, capacity, version) VALUES ('幹部用会議室', 10, 1);
INSERT INTO room_with_version(room_name, capacity, version) VALUES ('セミナールーム', 30, 1);
INSERT INTO room_with_version(room_name, capacity, version) VALUES ('カンファレンスルーム', 100, 1);

INSERT INTO counter(count, version) VALUES (0, 1);
INSERT INTO counter(count, version) VALUES (0, 1);
INSERT INTO counter(count, version) VALUES (0, 1);

