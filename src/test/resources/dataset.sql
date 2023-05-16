-- Tabla Odontologo
INSERT INTO odontologo (id, nombre, direccion, telefono, correo, password) VALUES (1111,  'Juan Perez', 'Calle 123', '555-1234', 'juan.perez@example.com', 'secreto123');
INSERT INTO odontologo (id, nombre, direccion, telefono, correo, password) VALUES (2222,  'Maria Gonzalez', 'Avenida 456', '555-5678', 'maria.gonzalez@example.com', 'clave123');
INSERT INTO odontologo (id, nombre, direccion, telefono, correo, password) VALUES (3333,  'Pedro Ramirez', 'Carrera 789', '555-4321', 'pedro.ramirez@example.com', 'password123');
INSERT INTO odontologo (id, nombre, direccion, telefono, correo, password) VALUES (4444,  'Luisa Lopez', 'Calle 321', '555-8765', 'luisa.lopez@example.com', 'secreto456');
INSERT INTO odontologo (id, nombre, direccion, telefono, correo, password) VALUES (5555,  'Alejandro Rodriguez', 'Avenida 987', '555-2345', 'alejandro.rodriguez@example.com', 'clave456');

-- Tabla Instrumental
INSERT INTO instrumental (id, nombre, marca, registro, cantidad) VALUES (1, 'Torno dental', 'BienAir', '20190415', 3);
INSERT INTO instrumental (id, nombre, marca, registro, cantidad) VALUES (2, 'Caja de exploración', 'Hu-Friedy', '20180101', 2);
INSERT INTO instrumental (id, nombre, marca, registro, cantidad) VALUES (3, 'Lámpara de fotocurado', 'Woodpecker', '20190228', 4);
INSERT INTO instrumental (id, nombre, marca, registro, cantidad) VALUES (4, 'Jeringa trilux', '3M', '20200510', 5);
INSERT INTO instrumental (id, nombre, marca, registro, cantidad) VALUES (5, 'Kit de ortodoncia', 'Kavo', '20190905', 1);

-- Tabla Tratamiento
INSERT INTO tratamiento (id, descripcion, nombre) VALUES (1, 'Empaste de una muela', 'Empaste');
INSERT INTO tratamiento (id, descripcion, nombre) VALUES (2, 'Limpieza dental', 'Limpieza');
INSERT INTO tratamiento (id, descripcion, nombre) VALUES (3, 'Extracción de una muela', 'Extracción');
INSERT INTO tratamiento (id, descripcion, nombre) VALUES (4, 'Ortodoncia', 'Ortodoncia');
INSERT INTO tratamiento (id, descripcion, nombre) VALUES (5, 'Implante dental', 'Implante');


-- Tabla Paciente
INSERT INTO paciente (documento, nombre, direccion, telefono, correo, genero, fecha_nacimiento, fecha_registro) VALUES (12345678, 'Juan Perez', 'Calle 123', '555-1234', 'juanperez@example.com', 'H', '1990-05-25', '2022-04-18');
INSERT INTO paciente (documento, nombre, direccion, telefono, correo, genero, fecha_nacimiento, fecha_registro) VALUES (87654321, 'Maria Garcia', 'Avenida 456', '555-5678', 'mariagarcia@example.com', 'M', '1985-10-12', '2022-04-18');
INSERT INTO paciente (documento, nombre, direccion, telefono, correo, genero, fecha_nacimiento, fecha_registro) VALUES (11111111, 'Luisa Martinez', 'Carrera 789', '555-9876', 'luisamartinez@example.com', 'M', '1978-08-02', '2022-04-18');
INSERT INTO paciente (documento, nombre, direccion, telefono, correo, genero, fecha_nacimiento, fecha_registro) VALUES (22222222, 'Pedro Gonzalez', 'Calle 456', '555-4321', 'pedrogonzalez@example.com', 'H', '1995-12-17', '2022-04-18');
INSERT INTO paciente (documento, nombre, direccion, telefono, correo, genero, fecha_nacimiento, fecha_registro) VALUES (33333333, 'Ana Rodriguez', 'Avenida 789', '555-8765', 'anarodriguez@example.com', 'M', '2000-03-10', '2022-04-18');

-- Tabla Agenda
INSERT INTO Agenda (id, estado, fecha, hora, odontologo_id, paciente_documento) VALUES (1, 'confirmado', '2023-04-20', '10:00:00', 1, 12345678);
INSERT INTO Agenda (id, estado, fecha, hora, odontologo_id, paciente_documento) VALUES (2, 'por confirmar', '2023-04-21', '14:30:00', 2, 87654321);
INSERT INTO Agenda (id, estado, fecha, hora, odontologo_id, paciente_documento) VALUES (3, 'por confirmar', '2023-04-22', '16:45:00', 3, 11111111);
INSERT INTO Agenda (id, estado, fecha, hora, odontologo_id, paciente_documento) VALUES (4, 'confirmado', '2023-04-23', '09:15:00', 3, 22222222);
INSERT INTO Agenda (id, estado, fecha, hora, odontologo_id, paciente_documento) VALUES (5, 'confirmado', '2023-04-24', '11:30:00', 5, 33333333);

-- Tabla InfoBasica
INSERT INTO info_basica (id, nombre_acompanante, telefono_acompante, motivo, antecedentes_medicos_personales, estomatologico) VALUES (1, 'Luisa Pérez', '555-1234', 'Acompañamiento a su hijo', 'Hipertensión arterial', 'Caries dental');
INSERT INTO info_basica (id, nombre_acompanante, telefono_acompante, motivo, antecedentes_medicos_personales, estomatologico) VALUES (2, 'Pedro Ramírez', '555-4321', 'Acompañamiento a su esposa', 'Diabetes', 'Gingivitis');
INSERT INTO info_basica (id, nombre_acompanante, telefono_acompante, motivo, antecedentes_medicos_personales, estomatologico) VALUES (3, 'María Gómez', '555-5678', 'Acompañamiento a su madre', 'Ninguno', 'Extracción de muela');
INSERT INTO info_basica (id, nombre_acompanante, telefono_acompante, motivo, antecedentes_medicos_personales, estomatologico) VALUES (4, 'Juan López', '555-8765', 'Acompañamiento a su abuelo', 'Artritis', 'Limpieza dental');
INSERT INTO info_basica (id, nombre_acompanante, telefono_acompante, motivo, antecedentes_medicos_personales, estomatologico) VALUES (5, 'Ana Castro', '555-2345', 'Acompañamiento a su hermano', 'Alergias', 'Ortodoncia');

-- Tabla Concentimiento
INSERT INTO concentimiento (id, fecha, nombre, procedimiento, riesgos) VALUES (1, '2023-04-18', 'Juan Perez', 'Limpieza dental', 'Sensibilidad dental temporal');
INSERT INTO concentimiento (id, fecha, nombre, procedimiento, riesgos) VALUES (2, '2023-04-19', 'Ana Lopez', 'Extracción dental', 'Inflamación, sangrado, dolor');
INSERT INTO concentimiento (id, fecha, nombre, procedimiento, riesgos) VALUES (3, '2023-04-20', 'Pedro Ramirez', 'Implante dental', 'Infección, rechazo del implante');
INSERT INTO concentimiento (id, fecha, nombre, procedimiento, riesgos) VALUES (4, '2023-04-21', 'María Rodriguez', 'Ortodoncia', 'Dolor, irritación en las encías');
INSERT INTO concentimiento (id, fecha, nombre, procedimiento, riesgos) VALUES (5, '2023-04-22', 'Lucas García', 'Blanqueamiento dental', 'Sensibilidad dental, decoloración irregular');

-- Tabla HistorialMedico
INSERT INTO historial_medico (id, fecha_inicial, hora_inicial, concentimiento_id, info_basica_id, doc_paciente) VALUES (1, '2023-04-18', '09:30:00', 1, 2, 12345678);
INSERT INTO historial_medico (id, fecha_inicial, hora_inicial, concentimiento_id, info_basica_id, doc_paciente) VALUES (2, '2023-04-18', '10:00:00', 2, 3, 87654321);
INSERT INTO historial_medico (id, fecha_inicial, hora_inicial, concentimiento_id, info_basica_id, doc_paciente) VALUES (3, '2023-04-18', '11:30:00', 3, 4, 11111111);
INSERT INTO historial_medico (id, fecha_inicial, hora_inicial, concentimiento_id, info_basica_id, doc_paciente) VALUES (4, '2023-04-18', '12:00:00', 4, 5, 22222222);
INSERT INTO historial_medico (id, fecha_inicial, hora_inicial, concentimiento_id, info_basica_id, doc_paciente) VALUES (5, '2023-04-18', '14:00:00', 5, 1, 33333333);

-- Tabla HistorialCita
INSERT INTO historial_cita (id, asistencia, descripcion, agenda_id, paciente_documento, tratamiento_id) VALUES (1, 'asistió', 'Limpieza dental', 1, '12345678', 1);
INSERT INTO historial_cita (id, asistencia, descripcion, agenda_id, paciente_documento, tratamiento_id) VALUES (2, 'no asistió', 'No se hizo nada', 2, '87654321', 2);
INSERT INTO historial_cita (id, asistencia, descripcion, agenda_id, paciente_documento, tratamiento_id) VALUES (3, 'asistió', 'Caries en el diente 24', 3, '11111111', 3);
INSERT INTO historial_cita (id, asistencia, descripcion, agenda_id, paciente_documento, tratamiento_id) VALUES (4, 'asistió', 'Sellante dental', 4, '22222222', 4);
INSERT INTO historial_cita (id, asistencia, descripcion, agenda_id, paciente_documento, tratamiento_id) VALUES (5, 'asistió', 'Extracción del diente 36', 5, '33333333', 5);

-- Tabla HistorialTratamiento
INSERT INTO historial_tratamiento (id, estado, paciente_documento, tratamiento_id) VALUES (1, 'En Proceso', '12345678', 1);
INSERT INTO historial_tratamiento (id, estado, paciente_documento, tratamiento_id) VALUES (2, 'En Espera', '87654321', 2);
INSERT INTO historial_tratamiento (id, estado, paciente_documento, tratamiento_id) VALUES (3, 'Cancelado', '11111111', 3);
INSERT INTO historial_tratamiento (id, estado, paciente_documento, tratamiento_id) VALUES (4, 'Terminado', '22222222', 3);
INSERT INTO historial_tratamiento (id, estado, paciente_documento, tratamiento_id) VALUES (5, 'En Proceso', '33333333', 5);

-- Tabla Odontograma
INSERT INTO odontograma (id, num_diente, descripcion, paciente_documento) VALUES (1, 11, 'Caries en el diente', 12345678);
INSERT INTO odontograma (id, num_diente, descripcion, paciente_documento) VALUES (2, 26, 'Diente con infección', 87654321);
INSERT INTO odontograma (id, num_diente, descripcion, paciente_documento) VALUES (3, 47, 'Fractura en el diente', 11111111);
INSERT INTO odontograma (id, num_diente, descripcion, paciente_documento) VALUES (4, 85, 'Diente faltante', 22222222);
INSERT INTO odontograma (id, num_diente, descripcion, paciente_documento) VALUES (5, 33, 'Desgaste en el diente', 33333333);

