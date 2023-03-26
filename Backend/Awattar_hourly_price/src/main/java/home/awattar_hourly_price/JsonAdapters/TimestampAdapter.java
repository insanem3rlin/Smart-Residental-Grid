package home.awattar_hourly_price.JsonAdapters;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;

public class TimestampAdapter extends TypeAdapter<Timestamp> {

    @Override
    public void write(JsonWriter out, Timestamp value) throws IOException {
        if (value == null) {
            out.nullValue();
        } else {
            out.value(value.getTime());
        }
    }

    @Override
    public Timestamp read(JsonReader in) throws IOException {
        long milliseconds = in.nextLong();
        return new Timestamp(milliseconds);
    }
}