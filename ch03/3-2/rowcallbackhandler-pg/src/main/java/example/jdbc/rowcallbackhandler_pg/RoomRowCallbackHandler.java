package example.jdbc.rowcallbackhandler_pg;

import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.util.StringUtils;

public class RoomRowCallbackHandler implements RowCallbackHandler {
	private final BufferedWriter writer;
	public RoomRowCallbackHandler(BufferedWriter writer) {
		this.writer = writer;
	}
			
	@Override
	public void processRow(ResultSet rs) throws SQLException {
		Object[] values = new Object[] {
			rs.getString("room_id"),
			rs.getString("room_name"),
			rs.getInt("capacity")
		};
		String line = StringUtils.arrayToCommaDelimitedString(values);
		try {
			writer.write(line);
			writer.newLine();
		} catch(IOException e) {
			throw new SQLException(e);
		}
	}

}
