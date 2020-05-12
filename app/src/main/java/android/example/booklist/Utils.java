package android.example.booklist;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

                /**
                 * For a given book, extract the JSONObject associated with the
                 * key called "imageLinks", which represents a list of all images
                 * associated with that book
                 */
                String thumbnail;
                JSONObject imageLinks = volumeInfo.getJSONObject("imageLinks");

                //extract string url for the specific book cover
                String imageUrl = imageLinks.getString("smallThumbnail");

                //Extract JSONString associated with title
                String title = volumeInfo.getString("title");


                //Extract JSONString associated with description
                String description = volumeInfo.getString("description");

                //extract the string associated with language
                String language = volumeInfo.getString("language");

                //Extract JSONSint associated with description
                int cost = volumeInfo.getInt("");

                //extract number of pages
                int pageCount = volumeInfo.getInt("pageCount");

                //extract the star rating
                int starRating = volumeInfo.getInt("");

            }

        }catch(JSONException e){
            /**
             * If an error is thrown when executing any of the above statements int the try block
             * catch the exception here, so the app doesn't crash. Print the log message
             * with the message from the exception
             */
            Log.e(LOG_TAG, "Problme with parsing the book ", e);
        }
        return books;
    }
}
