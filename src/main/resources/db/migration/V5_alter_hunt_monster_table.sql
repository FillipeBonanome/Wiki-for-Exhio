ALTER TABLE hunt_monster DROP FOREIGN KEY monster_id;
ALTER TABLE hunt_monster ADD FOREIGN KEY (monster_id) REFERENCES monsters(id);