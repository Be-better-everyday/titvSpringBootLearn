SELECT
  setval(
    pg_get_serial_sequence('classes', 'id'),
    (
      SELECT
        MAX(id)
      FROM
        classes
    )+ 1
  );

SELECT
  setval(
    pg_get_serial_sequence('schools', 'id'),
    (
      SELECT
        MAX(id)
      FROM
        schools
    )+ 1
  );

SELECT
  setval(
    pg_get_serial_sequence('students', 'id'),
    (
      SELECT
        MAX(id)
      FROM
        students
    )+ 1
  );

SELECT
  setval(
    pg_get_serial_sequence('teachers', 'id'),
    (
      SELECT
        MAX(id)
      FROM
        teachers
    )+ 1
  );

SELECT
  setval(
    pg_get_serial_sequence('teacher_class', 'id'),
    (
      SELECT
        MAX(id)
      FROM
        teacher_class
    )+ 1
  );