   CREATE DATABASE IF NOT EXISTS biblioteca_untc;
   USE biblioteca_untc;

   CREATE TABLE IF NOT EXISTS libros (
       id INT AUTO_INCREMENT PRIMARY KEY,
       titulo VARCHAR(255) NOT NULL,
       idioma VARCHAR(50),
       autor VARCHAR(255),
       editorial VARCHAR(255),
       paginas INT,
       prestado BOOLEAN DEFAULT FALSE
   );

   INSERT INTO libros (titulo, idioma, autor, editorial, paginas, prestado) VALUES 
   ('El Quijote', 'Español', 'Miguel de Cervantes', 'Alfaguara', 1000, FALSE),
   ('1984', 'Inglés', 'George Orwell', 'Debate', 350, TRUE),
   ('Harry Potter y la piedra filosofal', 'Español', 'J.K. Rowling', 'Salamandra', 309, FALSE),
   ('Cien años de soledad', 'Español', 'Gabriel García Márquez', 'Editorial Sudamericana', 417, TRUE),
   ('El Principito', 'Español', 'Antoine de Saint-Exupéry', 'Salamandra', 96, FALSE),
   ('Orgullo y prejuicio', 'Español', 'Jane Austen', 'Cátedra', 432, FALSE),
   ('El Hobbit', 'Español', 'J.R.R. Tolkien', 'Minotauro', 310, TRUE),
   ('Crimen y castigo', 'Español', 'Fiódor Dostoyevski', 'Alianza Editorial', 672, FALSE),
   ('Rayuela', 'Español', 'Julio Cortázar', 'Cátedra', 600, FALSE),
   ('La sombra del viento', 'Español', 'Carlos Ruiz Zafón', 'Planeta', 576, TRUE),
   ('Dune', 'Español', 'Frank Herbert', 'Debolsillo', 832, FALSE),
   ('El nombre de la rosa', 'Español', 'Umberto Eco', 'Lumen', 512, FALSE);