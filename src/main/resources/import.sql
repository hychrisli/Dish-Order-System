INSERT INTO branch (branch_id, address, name, phone) VALUES (1, 'San Jose', 'Order-N-Get', '800-232-232');

INSERT INTO user (username, password, address, phone, signup_date) VALUES ('cust1', '$2a$10$3sBJyEypIxm6q55sohk9KOqSGTtwC5K8geItdGoOmcHSZtGukfRk2', '1 Washington Square, San Jose, CA', '800-123-456', STR_TO_DATE('2017-11-01', '%Y-%m-%d'));
INSERT INTO user (username, password, address, phone, signup_date) VALUES ('admin1', '$2a$10$9tWe/MDXo.xoyFylWr9lBuJd2nQjZDspj19BCylKe..51v1qaLxUi', 'San Francisco', '800-123-456', STR_TO_DATE('2017-11-06', '%Y-%m-%d'));
INSERT INTO user (username, password, address, phone, signup_date) VALUES ('worker1', '$2a$10$B.y3H9ZObYjhrbzEkaUenOW0xdguHqWv3x4tLG4in.IIC5AX7HUJS', 'Santa Clara', '800-111-222', STR_TO_DATE('2017-11-06', '%Y-%m-%d'));

INSERT INTO customer (username) VALUES ('cust1');
INSERT INTO administrator (username) VALUES ('admin1');
INSERT INTO worker (username, branch_id) VALUES ('worker1', 1)