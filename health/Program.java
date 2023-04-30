
// Program.java
import com.algolia.search.DefaultSearchClient;
import com.algolia.search.SearchClient;
import com.algolia.search.SearchIndex;
import com.algolia.search.models.indexing.Query;
import com.algolia.search.models.indexing.SearchResult;

public class Program {
    public static void main(String[] args) {
        // Connect and authenticate with your Algolia app
        SearchClient client = DefaultSearchClient.create("undefined", "YourWriteAPIKey");

        // Create a new index and add a record (using the `Record` class)
        SearchIndex<Record> index = client.initIndex("test_index", Record.class);
        Record record = new Record("test_record", "1");
        index.saveObject(record).waitTask();

        // Search the index and print the results
        SearchResult<Record> results = index.search(new Query("test_record"));
        System.out.println(results.getHits().get(0));
    }
}
