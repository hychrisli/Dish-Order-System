INSERT INTO user (username, password, address, phone, signup_date) VALUES ('cust1', '$2a$10$3sBJyEypIxm6q55sohk9KOqSGTtwC5K8geItdGoOmcHSZtGukfRk2', '1 Washington Square, San Jose, CA', '800-123-456', STR_TO_DATE('2017-11-01', '%Y-%m-%d'));
INSERT INTO user (username, password, address, phone, signup_date) VALUES ('admin1', '$2a$10$9tWe/MDXo.xoyFylWr9lBuJd2nQjZDspj19BCylKe..51v1qaLxUi', 'San Francisco', '800-123-456', STR_TO_DATE('2017-11-06', '%Y-%m-%d'));

INSERT INTO administrator (username) VALUES ('admin1');