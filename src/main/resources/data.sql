-- Seed data for DnD Q&A tags
-- Place this file at: src/main/resources/data.sql
-- Spring Boot will run it automatically on startup.
--
-- If you use Hibernate's ddl-auto=create or create-drop, also add this to
-- application.properties to ensure the schema exists before the data is inserted:
--   spring.jpa.defer-datasource-initialization=true
-- See the duplicates first

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
  ('Exploration',   'Travel, navigation, traps, and environment');
