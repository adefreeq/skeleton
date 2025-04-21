package datatables;

import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTableConverter {

    public static Map<String, String> toMap(DataTable dataTable) {
        Map<String, String> body = new HashMap<>();

        if (dataTable != null && !dataTable.isEmpty()) {
            List<List<String>> rows = dataTable.asLists();

            for (List<String> row : rows) {
                if (row.size() >= 2 &&
                        row.get(0) != null && !row.get(0).isBlank() &&
                        row.get(1) != null) {
                    body.put(row.get(0), row.get(1));
                }
            }
        }

        return body;
    }
}
