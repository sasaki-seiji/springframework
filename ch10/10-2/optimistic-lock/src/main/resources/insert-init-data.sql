INSERT INTO room(room_name, capacity, version) VALUES ('幹部用会議室', 10, 1);
INSERT INTO room(room_name, capacity, version) VALUES ('セミナールーム', 30, 1);
INSERT INTO room(room_name, capacity, version) VALUES ('カンファレンスルーム', 100, 1);

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
