package ua.lviv.lgs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;
import java.time.ZoneId;
import java.util.Date;

public class Application {

	public static void main(String[] args) throws IOException {

		File file = new File("annotation.txt");
		writeFieldsWithAnnotations(file, Person.class);
	}

	public static void writeFieldsWithAnnotations(File file, Class<?> customClass) throws IOException {

		Field[] fields = customClass.getDeclaredFields();

		Writer wr = new FileWriter(file);

		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];

			if (field.getAnnotation(PersonField.class) instanceof PersonField) {
				wr.write(field.getName() + ", ");
			}
		}
		wr.close();
	}
}
