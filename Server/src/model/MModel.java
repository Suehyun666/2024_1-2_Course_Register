package model;
import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.Scanner;

public class MModel  {
	public MModel() {}

	public void read(ResultSet rs) throws Exception {}
	public String read(Scanner scanner) {
		String key = null;
		try {
			Field[] fields = this.getClass().getDeclaredFields();
			for (Field field: fields) {
				String fieldValue = scanner.next();
				field.setAccessible(true);
				field.set(this, fieldValue);
			}
			key = (String) fields[0].get(this);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return key;
	}
}
