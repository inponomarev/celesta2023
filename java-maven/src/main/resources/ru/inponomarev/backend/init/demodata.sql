-- Inserting customers
INSERT INTO "orders"."customer" ("name", "email", "description") VALUES
                                                    ('John Doe', 'johndoe@example.com', 'Regular customer'),
                                                    ('Jane Smith', 'janesmith@example.com', 'Preferred customer'),
                                                    ('Michael Johnson', 'michaeljohnson@example.com', 'New customer');

-- Inserting items
INSERT INTO "orders"."item" ("id", "name", "color", "default_price") VALUES
                                                      ('item001', 'Widget A', 'Blue', 10),
                                                      ('item002', 'Widget B', 'Red', 15),
                                                      ('item003', 'Widget C', 'Green', 20);

-- Inserting orders
INSERT INTO "orders"."order" ("customer_id", "item_id", "quantity", "price", "amount") VALUES
                                                                        (1, 'item001', 2, 10, 20),
                                                                        (1, 'item002', 1, 15, 15),
                                                                        (2, 'item003', 3, 20, 60),
                                                                        (3, 'item001', 1, 10, 10),
                                                                        (3, 'item002', 2, 15, 30),
                                                                        (1, 'item003', 2, 20, 40),
                                                                        (2, 'item001', 3, 10, 30),
                                                                        (2, 'item002', 1, 15, 15),
                                                                        (1, 'item003', 1, 20, 20),
                                                                        (3, 'item001', 2, 10, 20);
