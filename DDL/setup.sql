CREATE database dos;
CREATE USER 'dosuser'@'localhost' identified by -- < specify your password>;
GRANT ALL ON dos.* to 'dosuser'@'localhost';

-- After this setup, please configure environment variable DOSUSER_PASS with your password