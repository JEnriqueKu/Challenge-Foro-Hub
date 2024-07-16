-- Crear tabla Curso
CREATE TABLE curso (
    id_curso SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(100) NOT NULL
);

-- Crear tabla Perfil
CREATE TABLE perfil (
    id_perfil SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Crear tabla Usuario
CREATE TABLE usuario (
    id_autor SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo_electronico VARCHAR(200) NOT NULL,
    contrasena VARCHAR(200) NOT NULL
);

-- Crear tabla usuario_perfil para la relación muchos a muchos entre Usuario y Perfil
CREATE TABLE usuario_perfil (
    usuario_id INTEGER NOT NULL,
    perfil_id INTEGER NOT NULL,
    PRIMARY KEY (usuario_id, perfil_id),
    FOREIGN KEY (usuario_id) REFERENCES usuario(id_autor),
    FOREIGN KEY (perfil_id) REFERENCES perfil(id_perfil)
);

-- Crear tabla Topico
CREATE TABLE topico (
    id_topico SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    mensaje TEXT NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    status VARCHAR(100) NOT NULL,
    autor_id INTEGER NOT NULL,
    curso_id INTEGER NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuario(id_autor),
    FOREIGN KEY (curso_id) REFERENCES curso(id_curso)
);

-- Crear tabla Respuesta
CREATE TABLE respuesta (
    id_respuesta SERIAL PRIMARY KEY,
    mensaje TEXT NOT NULL,
    topico INTEGER NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id INTEGER NOT NULL,
    solucion BOOLEAN NOT NULL,
    FOREIGN KEY (topico) REFERENCES topico(id_topico),
    FOREIGN KEY (autor_id) REFERENCES usuario(id_autor)
);