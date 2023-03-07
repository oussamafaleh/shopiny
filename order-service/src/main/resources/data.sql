INSERT INTO shopiny_order_service.restaurant
(id, name)
VALUES('7ee80c8b-fde4-45aa-b499-51f697c227e8', 'miams');
INSERT INTO shopiny_order_service.restaurant
(id, name)
VALUES('d7879475-a752-41e0-a494-6c6a812d4e54', 'aromate');


INSERT INTO shopiny_order_service.menu_item
(id, name, amount)
VALUES('007b4e44-3bc7-4e20-b925-f36e72c1d4f8', 'pizza', 12.5);
INSERT INTO shopiny_order_service.menu_item
(id, name, amount)
VALUES('d7879475-a752-41e0-a494-6c6a812d4e54', 'panouzu', 75.0);
INSERT INTO shopiny_order_service.menu_item
(id, name, amount)
VALUES('6bf61577-ceed-4eae-a4f6-4ff3a06dbc6b', 'pasta', 22.0);

INSERT INTO shopiny_order_service.restaurant_menu_items
(restaurant_id, menu_items_id)
VALUES('7ee80c8b-fde4-45aa-b499-51f697c227e8', '007b4e44-3bc7-4e20-b925-f36e72c1d4f8');
INSERT INTO shopiny_order_service.restaurant_menu_items
(restaurant_id, menu_items_id)
VALUES('7ee80c8b-fde4-45aa-b499-51f697c227e8', 'd7879475-a752-41e0-a494-6c6a812d4e54');
INSERT INTO shopiny_order_service.restaurant_menu_items
(restaurant_id, menu_items_id)
VALUES('7ee80c8b-fde4-45aa-b499-51f697c227e8', '6bf61577-ceed-4eae-a4f6-4ff3a06dbc6b');
