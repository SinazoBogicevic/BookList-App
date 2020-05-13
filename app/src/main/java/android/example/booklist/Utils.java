package android.example.booklist;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class Utils {

    /**
     *
     * tag for the log messages
     */
    private static final String LOG_TAG = Utils.class.getSimpleName();


    /***
     * create a private constructor because non one ever creates a {@link Utils} object
     */
    private Utils(){}

    private static List<Book> extractBookFromJson(String bookJson){
        //If JSON string is empty or null, then return early.
        if(TextUtils.isEmpty(bookJson)){
            return null;
        }

        //Create an empty ArrayList that we can start adding books to
        List<Book> books = new ArrayList<>();

        /**
         * Try to parse the JSON response string. If there's a problem with the way the JSON
         * is formatted, a JSONException object will be thrown.
         * Catch the exception so the app doesn't crash and print the error message in logs
         */
        try{
            //Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(bookJson);
            Log.println(Log.INFO, LOG_TAG, bookJson);

            /**
             * Extract JSONArray associated with the key called 'items'
             * which represents a list of books
             */
            JSONArray booksArray = baseJsonResponse.getJSONArray("items");
            Log.println(Log.INFO, LOG_TAG, String.valueOf(booksArray));

            for(int i = 0; i < booksArray.length(); i++){
                //Get a single book at position i within the booksArray
                JSONObject currentBook = booksArray.getJSONObject(i);

                /**
                 * For a given book, extract the JSONObject associated with the
                 * key called "volumeInfo", which represents a list of all properties
                 * for that book
                 */
                JSONObject volumeInfo = currentBook.getJSONObject("volumeInfo");
                JSONObject saleInfo = currentBook.getJSONObject("saleInfo");

                // Extract the value for the key called "author"
                String author;

                //check if JSONArray exists
                if(volumeInfo.has("author")){
                    JSONArray authors = volumeInfo.getJSONArray("authors");
                    Log.println(Log.INFO, LOG_TAG, String.valueOf(authors));

                    if(!volumeInfo.isNull("authors")){
                        author = (String) authors.get(0);
                    }else {
                        //assign info about author
                        author = "** unknown authors **";
                    }
                }else {
                    //assign info about author
                    author = "** missing info on authors **";
                }

                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");

                //extract string url for the specific book cover
                String imageUrl = imageLinks.getString("smallThumbnail");

                //Extract JSONString associated with title
                String title = volumeInfo.getString("title");


                //Extract JSONString associated with description
                String description;
                if(volumeInfo.has("description")){
                     description = volumeInfo.getString("description");
                }else{
                    description = "** Description Unavailable";
                }

                //extract the string associated with language
                String language = volumeInfo.getString("language");

                //Extract String associated with price
                String saleAbility = saleInfo.getString("saleAbility");

                //extract number of pages
                int pageCount = volumeInfo.getInt("pageCount");

                int starRating = 0;
                //extract the star rating
                if(volumeInfo.has("averageRating")){
                    starRating = volumeInfo.getInt("averageRating");
                }

                //create a new {@link book} object
                books.add(new Book(title,author,imageUrl,starRating,saleAbility,pageCount,description,language));

            }

        }catch(JSONException e){
            Log.e(LOG_TAG, "Problem with parsing the book ", e);
        }
        return books;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */

    private static  String makeHttpRequest(URL url) throws IOException{

        // To avoid "magic numbers" in code, all numeric values mustn't been used directly in a code
        final int READ_TIMEOUT = 10000;
        final int CONNECT_TIMEOUT = 15000;
        final int CORRECT_RESPONSE_CODE = 200;

        String jsonResponse = "";

        if(url == null){
            return jsonResponse;
        }
        HttpURLConnection uRLConnection = null;
        InputStream inputStream = null;
    }

}
