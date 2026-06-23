-- Seed data for DnD Q&A tags
-- Place this file at: src/main/resources/data.sql
-- Spring Boot will run it automatically on startup.
--
-- If you use Hibernate's ddl-auto=create or create-drop, also add this to
-- application.properties to ensure the schema exists before the data is inserted:
--   spring.jpa.defer-datasource-initialization=true
-- See the duplicates first
SELECT name, COUNT(*) FROM tags GROUP BY name HAVING COUNT(*) > 1;

-- Then delete the duplicates, keeping only the lowest id of each name
DELETE t1 FROM tags t1
INNER JOIN tags t2
WHERE t1.id > t2.id AND t1.name = t2.name;

INSERT IGNORE INTO tags (name, description) VALUES
  ('Rules',         'Questions about official D&D rules and rulings'),
  ('Combat',        'Tactics, actions, reactions, and combat mechanics'),
  ('Magic',         'Spells, spell slots, concentration, and magic items'),
  ('Character',     'Character creation, classes, subclasses, and backgrounds'),
  ('Races',         'Playable races and their traits'),
  ('Monsters',      'Monster stat blocks, abilities, and lore'),
  ('Worldbuilding', 'Setting, lore, and narrative world design'),
  ('DM Advice',     'Guidance and tips for Dungeon Masters'),
  ('Player Advice', 'Guidance and tips for players'),
  ('Items',         'Weapons, armour, and non-magical equipment'),
  ('Magic Items',   'Attunement, identification, and specific magic items'),
  ('Feats',         'Feat selection and interactions'),
  ('Multiclassing', 'Multiclass rules, combinations, and builds'),
  ('Skills',        'Skill checks, proficiency, and ability scores'),
  ('Exploration',   'Travel, navigation, traps, and environment'),
  ('5e (2024)',		'D&D 5th Edition (2024 Revision)'),
  ('5e',			'D&D 5th Edition (2014)'),
  ('4e',			'D&D 4th Edition (2008)'),
  ('3.5e',			'D&D 3.5 Edition (2003)'),
  ('3e',			'D&D 3rd Edition (2000)'),
  ('2e',			'Advanced D&D 2nd Edition (1989)'),
  ('Adv 1e',		'Advanced D&D 1st Edition'),
  ('1e',			'Original D&D & Basic D&D (1974-1994)'),
  ('Spells',		''),
  ('Multiclassing',	''),
  ('Initiative',	''),
  ('Other',   'Other');
