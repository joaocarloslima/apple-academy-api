CREATE TABLE time_log (
  id UUID PRIMARY KEY,
  date DATE NOT NULL,
  time TIME NOT NULL,
  latitude DOUBLE PRECISION,
  longitude DOUBLE PRECISION,
  student_id UUID NOT NULL,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP
);

ALTER TABLE time_log
    ADD CONSTRAINT fk_time_log_student
        FOREIGN KEY (student_id)
            REFERENCES student(id);